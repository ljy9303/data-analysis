package ziller.core.crawler.model.quasar;

import lombok.Data;

@Data
public class QuasarContentsModel {

    private String title; // 제목명 <p class="tit">
    private String url; // 상품페이지 <a href="/bbs/qb_saleinfo/views/940990?page=1"
    private String category; // 카테고리 <span class="category">
    private String saleAmount; // 가격 <span class="text-orange">
    private String brand; // 브랜드 <span class="brand">
    private String ImageUrl; // 상품이미지 Url
    private String deliveryFee; // 배송비
}
