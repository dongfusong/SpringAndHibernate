package model;

import com.huipay.order.entity.BaseHuipayOrder;
import com.huipay.order.manager.HuipayOrderManager;
import com.huipay.pay.PayConfig;
import com.huipay.pay.PayItem;
import com.huipay.sms.entity.PayChannel;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Thoughtworks on 15/9/5.
 */
public class AppConfiguration {


    public AppConfiguration() {

    }

    public void init(){
        try {
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document document = builder.parse(new File("app.xml"));
            Element confRootEle = document.getDocumentElement();
            parsePayItem(getConfigElement("pay", confRootEle));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void parsePayItem(Element payElement) {
        NodeList nodeList = payElement.getElementsByTagName("payItem");
        for (int i = 0; i < nodeList.getLength(); i++){
            Element element = (Element) nodeList.item(i);
            System.out.println(element.getAttribute("name"));
        }
    }

    private Element getConfigElement(String pay, Element confRootEle) {
        return (Element) confRootEle.getElementsByTagName(pay).item(0);
    }


    public void confirmPay(){
        String orderStr = "";
        Map<String, String> params = new HashMap<String, String>();
        PayChannel payChannel = PayChannel.getByIntValue(1);
        PayItem payItem = PayConfig.getByChannel(payChannel);
        Map<String, String> results = payItem.directPay(params);

        BaseHuipayOrder order = HuipayOrderManager.getInstance()
                .getOrderByOrderId(orderStr.trim(), false);

        HuipayOrderManager.getInstance().confirmPayMethod(order, payChannel, results.get("tn"));
    }
}
