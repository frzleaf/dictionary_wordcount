package le.thanh.wordcounter;

import le.thanh.wordcounter.dto.WordCounterResult;
import le.thanh.wordcounter.service.SimpleHtmlWordCounterService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SimpleHtmlWordCounterServiceTest {

    private String sampleInput = "<h1>Tổng giám đốc Starbucks Việt Nam: 'Ly nước 90.000 đồng thành thức uống hàng ngày'</h1>\n" +
            "\n" +
            "<p>Tổng giám đốc Starbucks Việt Nam xác nhận kết quả tài chính năm 2021 không bằng trước dịch nhưng ly nước 90.000 đồng của họ đã thành \"cà phê hàng ngày\". \"Nói về những con số thì kết quả kinh doanh năm qua không thể bằng 2020 và rất xa so với những năm bình thường\", bà Patricia Marques, Tổng giám đốc Starbucks Việt Nam chia sẻ mới đây. Không nói con số cụ thể nhưng bà Patricia cho rằng, đây là điều dễ hiểu vì năm 2020 giãn cách chỉ khoảng hai tuần, còn năm qua tổng thời gian giãn cách kéo dài chín tuần, trong đó có giai đoạn hoàn toàn không kinh doanh gì ở nhiều cửa hàng.</p>\n" +
            "\n" +
            "<p>Dù thừa nhận kết quả tài chính thấp, Starbucks vẫn \"ăn nên làm ra\" ở một số mặt khác. Đó là chuỗi đã xây dựng được tập khách hàng thường xuyên, chấp nhận một ly nước giá 90.000-100.000 đồng. \"Starbucks đến thời điểm này có thể nói đã trở thành cà phê hàng ngày của khách hàng rồi\", bà Patricia tự tin.</p>";


    @Test
    public void testCounter() {
        SimpleHtmlWordCounterService counterService = new SimpleHtmlWordCounterService();
        WordCounterResult result = counterService.count(sampleInput);
        Assertions.assertEquals(result.getWords(), 198);
        Assertions.assertEquals(result.getSentences(), 7);
    }
}
