package com.epam.testautomation.page;
public interface iPage<P> {
    void openPage();

    void verifyTitleDisplayed();

    P openByUrl(Object... params);

    P waitForUrl(String... params);

    String getCurrentUrl();

    P waitForLoading();
}
