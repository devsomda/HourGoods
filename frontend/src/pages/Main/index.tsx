import React from "react";
import { Link } from "react-router-dom";
import "./index.scss";

export default function index() {
  return (
    <div>
      <div>
        <h5>임시 가이드라인 정보</h5>
        <p>mobile: red</p>
        <p>tablet: green</p>
        <p>desktop: blue</p>
        <button
          type="button"
          style={{ margin: "20px", backgroundColor: "yellow" }}
        >
          <Link to="/create/deal">딜 생성하기</Link>
        </button>
      </div>
    </div>
  );
}
