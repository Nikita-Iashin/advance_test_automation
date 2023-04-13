package com.epam.testautomation.page;

public abstract class BasePage<P extends BasePage<P>> implements iPage<P> {
    @Override
    public void openPage() {

    }

    @Override
    public void verifyTitleDisplayed() {

    }

    @Override
    public P openByUrl(Object... params) {
        return null;
    }

    @Override
    public P waitForUrl(String... params) {
        return null;
    }

    @Override
    public String getCurrentUrl() {
        return null;
    }

    @Override
    public P waitForLoading() {
        return null;
    }
}
