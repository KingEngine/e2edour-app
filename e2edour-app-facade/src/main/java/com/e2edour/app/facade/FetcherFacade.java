package com.e2edour.app.facade;

import com.e2edour.app.facade.bean.FetcherIndexBO;
import com.e2edour.app.facade.response.CommonResponse;
import com.e2edour.common.bean.Page;

import java.util.List;

/**
 * 爬虫 facade
 * Created by King on 2015/11/11.
 */
public interface FetcherFacade {

    List<FetcherIndexBO> getFetcherIndexs();

    Page<FetcherIndexBO> queryFetcherIndexsForPage(Page<?> page);

    CommonResponse addFetcherIndex(FetcherIndexBO fetcherIndexBO);

    CommonResponse deleteFetcherIndex(FetcherIndexBO fetcherIndexBO);
}
