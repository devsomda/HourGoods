import React, { useEffect } from "react";
import { mypageAPI } from "@api/apis";
import axios from "axios";
import { useNavigate } from "react-router";

const index: React.FC = () => {
  const navigate = useNavigate();
  useEffect(() => {
    const params = {
      cid: "TC0ONETIME",
      // localstorage에서 tid값을 읽어온다.
      tid: window.localStorage.getItem("tid"),
      partner_order_id: "partner_order_id",
      partner_user_id: "partner_user_id",
      pg_token: "",
    };

    const pgToken = window.location.search.split("=")[1];
    params.pg_token = pgToken;

    axios({
      url: "https://kapi.kakao.com/v1/payment/approve",
      method: "POST",
      headers: {
        Authorization: "KakaoAK de0e3076b485b703b1f1a4a2419440e6",
        "Content-type": "application/x-www-form-urlencoded;charset=utf-8",
      },
      params,
    })
      .then((response) => {
        // 결제 승인에 대한 응답 출력
        console.log(response);
        const pay = response.data.amount.total;
        mypageAPI
          .charge(pay)
          .then((res) => {
            console.log(res);
            navigate("/ticket"); // 전체 검색인 경우 클릭시 디테일 페이지로 이동
          })
          .catch((err) => {
            console.log(err);
          });
      })
      .catch((error) => {
        // 에러 핸들링
        console.log(error);
      });
  }, []);

  return (
    <div>
      <h2>Result page</h2>
    </div>
  );
};

export default index;
