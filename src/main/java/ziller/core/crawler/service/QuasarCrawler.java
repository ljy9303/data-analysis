package ziller.core.crawler.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;
import ziller.core.crawler.model.quasar.QuasarContentsModel;

import javax.annotation.PostConstruct;
import java.io.IOException;

@Service
public class QuasarCrawler {

    @PostConstruct
    public void getQuasarData() throws IOException{
        String url = "https://quasarzone.com/bbs/qb_saleinfo?page=1";
        Document doc = Jsoup.connect(url).get();
        Elements contents = doc.select("table tbody tr");

        for(Element el : contents) {

            Element divContent = el.select("div.market-info-sub > p").first();

            QuasarContentsModel content = new QuasarContentsModel();
            content.setTitle(el.selectFirst("span.ellipsis-with-reply-cnt").text());
            content.setUrl(el.select("a").first().attr("abs:href"));
            content.setCategory(el.selectFirst("span.category").text());
            content.setSaleAmount(el.selectFirst("span.text-orange").text());
            content.setBrand(el.selectFirst("span.brand").text());
            content.setImageUrl(el.select("img").attr("src"));
            content.setDeliveryFee(divContent.select("span:nth-child(5)").text());

        }

    }

}
