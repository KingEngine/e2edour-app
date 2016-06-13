use joke;

db.operator.insert({ "_id" : ObjectId("5658289a35541fc2af0478e4"), "name" : "wangkechao", "pwd" : "EFDF8C54A912EE69996BA7160BA9189A"});

db.menus.insert({ "_id" : ObjectId("564ec8818a26a918482aea21"), "_class" : "com.e2edour.app.dao.bean.MenusDO", "menu_id" : "1000", "name" : "内容管理", "menu_level" : "1", "parent_menu_id" : "#" });
db.menus.insert({ "_id" : ObjectId("564ec8818a26a918482aea23"), "_class" : "com.e2edour.app.dao.bean.MenusDO", "menu_id" : "1102", "name" : "未审核贴管理", "menu_level" : "3", "url" : "topicsManager/uncheckedTopicsManager/pagePre", "parent_menu_id" : "1100"});
db.menus.insert({ "_id" : ObjectId("564f18994fd90b257c52cd4f"), "_class" : "com.e2edour.app.dao.bean.MenusDO", "menu_id" : "6000", "name" : "爬虫管理", "menu_level" : "1", "parent_menu_id" : "#" });
db.menus.insert({ "_id" : ObjectId("564f18994fd90b257c52cd50"), "_class" : "com.e2edour.app.dao.bean.MenusDO", "menu_id" : "6100", "name" : "爬虫管理", "menu_level" : "2", "parent_menu_id" : "6000" });
db.menus.insert({ "_id" : ObjectId("564f18994fd90b257c52cd51"), "_class" : "com.e2edour.app.dao.bean.MenusDO", "menu_id" : "6101", "name" : "爬虫管理", "menu_level" : "3", "url" : "fetcherIndexsManager/pagePre", "parent_menu_id" : "6100" });
db.menus.insert({ "_id" : ObjectId("564f291f09702515644f56a8"), "_class" : "com.e2edour.app.dao.bean.MenusDO", "menu_id" : "7000", "name" : "配置管理", "menu_level" : "1", "parent_menu_id" : "#" });
db.menus.insert({ "_id" : ObjectId("564f291f09702515644f56a9"), "_class" : "com.e2edour.app.dao.bean.MenusDO", "menu_id" : "7100", "name" : "前端管理", "menu_level" : "2", "parent_menu_id" : "7000" });
db.menus.insert({ "_id" : ObjectId("564f291f09702515644f56aa"), "_class" : "com.e2edour.app.dao.bean.MenusDO", "menu_id" : "7101", "name" : "导航栏管理", "menu_level" : "3", "url" : "settingManger/frontManager/navigationManager/pagePre", "parent_menu_id" : "7100" });
db.menus.insert({ "_id" : ObjectId("565318544fd90b22a4761e1a"), "_class" : "com.e2edour.app.dao.bean.MenusDO", "menu_id" : "7200", "name" : "后端管理", "menu_level" : "2", "parent_menu_id" : "7000" });
db.menus.insert({ "_id" : ObjectId("56556382e60d732a34983b02"), "_class" : "com.e2edour.app.dao.bean.MenusDO", "menu_id" : "7201", "name" : "菜单管理", "menu_level" : "3", "url" : "settingManger/backManager/menusManager/pagePre", "parent_menu_id" : "7200" });
db.menus.insert({ "_id" : ObjectId("56569f9472dd0b1f40e97aa8"), "_class" : "com.e2edour.app.dao.bean.MenusDO", "menu_id" : "1100", "name" : "笑话管理", "menu_level" : "2", "url" : "#", "parent_menu_id" : "1000" });
db.menus.insert({ "_id" : ObjectId("5656a4d272dd0b2524a95c24"), "_class" : "com.e2edour.app.dao.bean.MenusDO", "menu_id" : "1200", "name" : "文章管理", "menu_level" : "2", "url" : "#", "parent_menu_id" : "1000" });
db.menus.insert({ "_id" : ObjectId("5656b21972dd0b2524a95c25"), "_class" : "com.e2edour.app.dao.bean.MenusDO", "menu_id" : "1201", "name" : "新增文章", "menu_level" : "3", "url" : "contentManager/eaasyManager/eaasyAdd/pagePre", "parent_menu_id" : "1200" });

db.navigation.insert({ "_id" : ObjectId("56580cafba831f173cc0de28"), "_class" : "com.e2edour.app.dao.bean.NavigationDO", "name" : "文字笑话", "code" : "E2E_NAV_0001", "url" : "getTopics/Text/1" });
db.navigation.insert({ "_id" : ObjectId("56580cafba831f173cc0de29"), "_class" : "com.e2edour.app.dao.bean.NavigationDO", "name" : "马又点虫", "code" : "E2E_NAV_0002", "url" : "getEaasy/1" });


db.checked_topics.insert({ "_id" : ObjectId("56585449af5b9a08d674f6fb"), "_class" : "com.e2edour.app.dao.bean.CheckedTopicsDO", "type" : "Text", "title" : "陛下……避下", "content" : "<p> 我刚走到胡同里，就听见天台上有人叫： “陛下……陛下！” 于是我仰面应了一声：“干吗！” 然后就被泼了一身的水。 楼上泼水的女的说：“早喊了， 让你避一下嘛， 你怎么一点反响都没有呢？” </p>", "createDate" : ISODate("2015-11-30T07:32:19.602Z"), "channel" : "Fetcher", "author" : "http://www.klbaomihua.com/text/index.html"});
db.unchecked_topics.insert({ "_id" : ObjectId("56512121af5b9a08d674f6fb"), "_class" : "com.e2edour.app.dao.bean.CheckedTopicsDO", "type" : "Text", "title" : "陛下……避下", "content" : "<p> 我刚走到胡同里，就听见天台上有人叫： “陛下……陛下！” 于是我仰面应了一声：“干吗！” 然后就被泼了一身的水。 楼上泼水的女的说：“早喊了， 让你避一下嘛， 你怎么一点反响都没有呢？” </p>", "createDate" : ISODate("2015-11-30T07:32:19.602Z"), "channel" : "Fetcher", "author" : "http://www.klbaomihua.com/text/index.html"});

