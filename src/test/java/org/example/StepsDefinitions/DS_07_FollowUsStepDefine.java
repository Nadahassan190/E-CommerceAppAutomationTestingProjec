package org.example.StepsDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.PA_07_FollowMainPage;

public class DS_07_FollowUsStepDefine {

    PA_07_FollowMainPage Follow=new PA_07_FollowMainPage();

    @When ("user opens facebook link")
    public void user_opens_facebook_link() throws InterruptedException {Follow.FLW_1_FaceBookPOM();}
    @Then ("^facebook \"([^\"]*)\" is opened in new tab$")
    public void facebook_opened_in_new_tab(String FacbookURL) throws InterruptedException {Follow.FLW_2_FaceBookOpenedSuccessfulPOM();}

    @When ("user opens twitter link")
    public void user_opens_twitter_link() throws InterruptedException {Follow.FLW_3_TwitterPOM();}
    @Then ("^twitter \"([^\"]*)\" is opened in new tab$")
    public void twitter_opened_in_new_tab(String TwitterURL) throws InterruptedException {Follow.FLW_4_TwitterOpenedSuccessful();}


    @When ("user opens rss link")
    public void user_opens_rss_link() throws InterruptedException {Follow.FLW_5_RssPOM();}
    @Then ("^rss \"([^\"]*)\" is opened in new tab$")
    public void rss_opened_in_new_tab(String RSSURL) throws InterruptedException {Follow.FLW_6_RssOpenedSuccessful();}


    @When ("user opens youtube link")
    public void user_opens_youtube_link() throws InterruptedException {Follow.FLW_7_YouTubePOM();}
    @Then ("^youtube \"([^\"]*)\" is opened in new tab$")
    public void youtube_opened_in_new_tab(String YoutubeURL) throws InterruptedException {Follow.FLW_8_YouTubeOpenedSuccessful();}

}
