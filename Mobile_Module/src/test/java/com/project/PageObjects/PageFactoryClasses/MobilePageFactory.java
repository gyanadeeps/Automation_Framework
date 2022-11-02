package com.project.PageObjects.PageFactoryClasses;


import com.project.PageObjects.pages.HomePageUI;
import com.project.PageObjects.pages.IHomePageUI;

public class MobilePageFactory extends PageFactory
{

    public static IHomePageUI getHomepage()
    {
        return wrap(new HomePageUI(), IHomePageUI.class);
    }
}
