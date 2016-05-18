package test;

import java.util.Date;

import javax.annotation.Resource;

import com.e2edour.app.dao.bean.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.e2edour.common.security.SecurityFactory;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-config/application_persistence.xml")
public class JokeTest extends AbstractJUnit4SpringContextTests {
    @Resource
    private MongoTemplate template;


    @Test
    public void fetcherIndexInsert() {
        try {
            template.dropCollection("fetcher_index");
            FetcherIndex index = new FetcherIndex();
            index.setClassName("KlbaomihuaImgFetcherEngine");
            index.setUrls(new String[]{"http://www.klbaomihua.com/pic/132-1-1.html"});
            template.save(index);
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }

    @Test
    public void surpriseInsert() {
        Surprise surprise = new Surprise();
        surprise.setDesc("模拟可撕裂布料效果,效果逼真");
        surprise.setTitle("可撕裂布料");
        surprise.setLogoPath("images/buliao.jpg");
        surprise.setUrl("surprise/tearable-cloth/index.html");
        template.insert(surprise);
    }

    @Test
    public void menuInsert() {
//		MenusDO menuTopics1 = new MenusDO();
//        menuTopics1.setMenuId("1000");
//        menuTopics1.setName("笑话管理");
//        menuTopics1.setMenuLevel("1");
//        menuTopics1.setParentMenuId("#");
//        template.insert(menuTopics1);
////
//		MenusDO menuTopics2 = new MenusDO();
//        menuTopics2.setMenuId("1100");
//        menuTopics2.setName("笑话管理");
//        menuTopics2.setMenuLevel("2");
//        menuTopics2.setParentMenuId("1000");
//        template.insert(menuTopics2);
////
//		MenusDO menuTopics3 = new MenusDO();
//        menuTopics3.setMenuId("1102");
//        menuTopics3.setName("未审核贴管理");
//        menuTopics3.setMenuLevel("3");
//        menuTopics3.setParentMenuId("1100");
//        menuTopics3.setUrl("topicsManager/uncheckedTopicsManager/pagePre");
//        template.insert(menuTopics3);
        /*
        template.insert(menu);*/
		/*MenusDO menu = new MenusDO();
		menu.setMenuId("2000");
		menu.setName("微信管理");
		menu.setMenuLevel("1");
		menu.setParentMenuId("#");
		template.insert(menu);
		MenusDO menu = new MenusDO();
		menu.setMenuId("2100");
		menu.setName("微信管理");
		menu.setMenuLevel("2");
		menu.setParentMenuId("2000");
		template.insert(menu);
		
		MenusDO menu = new MenusDO();
		menu.setMenuId("2101");
		menu.setName("用户量查看");
		menu.setMenuLevel("3");
		menu.setParentMenuId("2100");
		template.insert(menu);
		
		MenusDO menu = new MenusDO();
		menu.setMenuId("3000");
		menu.setName("参数管理");
		menu.setMenuLevel("1");
		menu.setParentMenuId("#");
		template.insert(menu);
		
		MenusDO menu = new MenusDO();
		menu.setMenuId("4000");
		menu.setName("账户中心");
		menu.setMenuLevel("1");
		menu.setParentMenuId("#");
		template.insert(menu);
		
		MenusDO menu = new MenusDO();
		menu.setMenuId("4100");
		menu.setName("账户管理");
		menu.setMenuLevel("2");
		menu.setParentMenuId("4000");
		template.insert(menu);*/

//		MenusDO menu = new MenusDO();
//		menu.setMenuId("4101");
//		menu.setName("账户添加");
//		menu.setMenuLevel("3");
//		menu.setParentMenuId("4100");
//		menu.setUrl("");
//		template.insert(menu);
		
		/*MenusDO menu = new MenusDO();
		menu.setMenuId("5000");
		menu.setName("会员管理");
		menu.setMenuLevel("1");
		menu.setParentMenuId("#");
		*/
//        MenusDO menuFetcher1 = new MenusDO();
//        menuFetcher1.setMenuId("6000");
//        menuFetcher1.setName("爬虫管理");
//        menuFetcher1.setMenuLevel("1");
//        menuFetcher1.setParentMenuId("#");
//        template.insert(menuFetcher1);
//
//        MenusDO menuFetcher2 = new MenusDO();
//        menuFetcher2.setMenuId("6100");
//        menuFetcher2.setName("爬虫管理");
//        menuFetcher2.setMenuLevel("2");
//        menuFetcher2.setParentMenuId("6000");
//        template.insert(menuFetcher2);
//
//        MenusDO menuFetcher3 = new MenusDO();
//        menuFetcher3.setMenuId("6101");
//        menuFetcher3.setName("爬虫管理");
//        menuFetcher3.setMenuLevel("3");
//        menuFetcher3.setParentMenuId("6100");
//        menuFetcher3.setUrl("fetcherIndexsManager/pagePre");
//        template.insert(menuFetcher3);

//        MenusDO menuSetting1 = new MenusDO();
//        menuSetting1.setMenuId("7000");
//        menuSetting1.setName("配置管理");
//        menuSetting1.setMenuLevel("1");
//        menuSetting1.setParentMenuId("#");
//        template.insert(menuSetting1);
//
//        MenusDO menuSetting2 = new MenusDO();
//        menuSetting2.setMenuId("7100");
//        menuSetting2.setName("前端管理");
//        menuSetting2.setMenuLevel("2");
//        menuSetting2.setParentMenuId("7000");
//        template.insert(menuSetting2);
//
//        MenusDO menuSetting3 = new MenusDO();
//        menuSetting3.setMenuId("7101");
//        menuSetting3.setName("导航栏管理");
//        menuSetting3.setMenuLevel("3");
//        menuSetting3.setParentMenuId("7100");
//        menuSetting3.setUrl("settingManger/frontManager/navigationManager/pagePre");
//        template.insert(menuSetting3);
//
       /* MenusDO menuSetting2 = new MenusDO();
        menuSetting2.setMenuId("7200");
        menuSetting2.setName("后端管理");
        menuSetting2.setMenuLevel("2");
        menuSetting2.setParentMenuId("7000");
        template.insert(menuSetting2);*/

        MenusDO menuSetting3 = new MenusDO();
        menuSetting3.setMenuId("7201");
        menuSetting3.setName("菜单管理");
        menuSetting3.setMenuLevel("3");
        menuSetting3.setParentMenuId("7200");
        menuSetting3.setUrl("settingManger/backManager/menusManager/pagePre");
        template.insert(menuSetting3);
        //menuSetting3template.remove(menuSetting3);
        //template.dropCollection("menus");
        // template.remove(menu);
    }

    @Test
    public void insertOperator() {
        OperatorDO dao = new OperatorDO();
        dao.setName("wangkechao");
        dao.setPwd(SecurityFactory.signMD5("123456789"));
        template.insert(dao);
    }

    @Test
    public void insertNavigation() {
        template.dropCollection(NavigationDO.class);
        NavigationDO navigationDO = new NavigationDO();
        navigationDO.setName("文字笑话");
        navigationDO.setCode("E2E_NAV_0001");
        navigationDO.setUrl("getTopics/Text/1");
//		template.insert(navigationDO);
//		NavigationDO navigationDO = new NavigationDO();
//		navigationDO.setName("图片笑话");
//		navigationDO.setCode("E2E_NAV_0002");
//		navigationDO.setUrl("getImgeTopics");
//		NavigationDO navigationDO = new NavigationDO();
//		navigationDO.setName("聊天机器人");
//		navigationDO.setCode("E2E_NAV_0003");
//		navigationDO.setUrl("getBotChat");
//		template.insert(navigationDO);
//		NavigationDO navigationDO = new NavigationDO();
//		navigationDO.setName("投稿");
//		navigationDO.setCode("E2E_NAV_0004");
//		navigationDO.setUrl("getHandTopics");
        template.insert(navigationDO);
    }
}
