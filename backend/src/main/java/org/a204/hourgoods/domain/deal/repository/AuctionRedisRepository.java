package org.a204.hourgoods.domain.deal.repository;

import lombok.RequiredArgsConstructor;
import org.a204.hourgoods.domain.deal.entity.Auction;
import org.a204.hourgoods.domain.deal.entity.AuctionInfo;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;

@Repository
@RequiredArgsConstructor
public class AuctionRedisRepository {
    private final RedisTemplate<String, AuctionInfo> redisTemplate;
    private ValueOperations<String, AuctionInfo> valueOperations;
    @PostConstruct
    private void redisInit() {
        valueOperations = redisTemplate.opsForValue();
    }
    public boolean isExist(Long dealId) {
        String auctionKey = "auction:" + dealId;
        return valueOperations.get(auctionKey) != null;
    }
    public AuctionInfo addParticipant(Long dealId) {
        String auctionKey = "auction:" + dealId;
        AuctionInfo auctionInfo = valueOperations.get(auctionKey);
        auctionInfo.addParticipant();
        return auctionInfo;
    }
    public AuctionInfo initAuction(Auction auction) {
        String auctionKey = "auction:" + auction.getId();
        AuctionInfo auctionInfo = AuctionInfo.builder().minPrice(auction.getMinimumPrice()).build();
        valueOperations.set(auctionKey, auctionInfo);
        return valueOperations.get(auctionKey);
    }
    public Integer getParticipantCount(String dealId) {
        String auctionKey = "auction:" + dealId;
        AuctionInfo auctionInfo = valueOperations.get(auctionKey);
        return auctionInfo.getParticipantCount();
    }
}
