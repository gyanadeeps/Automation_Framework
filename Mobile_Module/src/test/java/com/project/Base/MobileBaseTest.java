package com.project.Base;




import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.open;

import static com.project.data.SystemProperties.URL;
import static org.assertj.core.api.Assertions.assertThat;

public abstract class MobileBaseTest extends BaseWebTest {
    private final List<Feature> features = new ArrayList<>();
    private String NCSAURL=null;

    protected MobileBaseTest() {
    }

    public MobileBaseTest add(Feature feature) {
        features.add(feature);
        return this;
    }

    public void trigger() {
        openNCSA();

        new FeatureExecutor(features).execute();
    }

    protected void openNCSA()
    {

//
//        if(AUTHENTICATION_REQUIRED.trim().equals("Yes") ){
//            NCSAURL  = "https://"+USERNAME+":"+PASSWORD+"@wwwncsa.ncsasports.org/";
//            System.err.println("Executing on URL-->" + NCSAURL);
//            open(NCSAURL);
//        }
//        else{
            assertThat(URL).isNotNull();
            System.err.println("Executing on URL-->" + URL);

            open(URL);
        }

    }


