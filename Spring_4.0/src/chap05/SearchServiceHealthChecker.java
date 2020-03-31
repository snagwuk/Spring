package chap05;

import java.util.List;

import chap022.SearchClient;
import chap022.SearchClientFactory;

public class SearchServiceHealthChecker
{
    private List<SearchClientFactory> factories;

    public void setFactories(List<SearchClientFactory> factories)
    {
        this.factories = factories;
    }
    public void check()
    {
        for(SearchClientFactory factory : factories)
        {
            SearchClient searchClient = factory.create();
            searchClient.checkLive();
        }
    }
}
