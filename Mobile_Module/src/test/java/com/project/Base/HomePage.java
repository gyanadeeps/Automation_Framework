package com.project.Base;



import com.project.PageObjects.PageFactoryClasses.MobilePageFactory;
import com.project.PageObjects.pages.IHomePageUI;


import static com.codeborne.selenide.Selenide.open;
import static com.project.data.SystemProperties.URL;


public class HomePage {



    public IHomePageUI openProFundHomePage()
    {
        open(URL);

        return MobilePageFactory.getHomepage();
    }


}
