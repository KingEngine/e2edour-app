package com.e2edour.app.facade;

import com.e2edour.app.facade.bean.CheckedEaasyBO;
import com.e2edour.app.facade.bean.UncheckedEaasyBO;
import com.e2edour.app.facade.response.CommonResponse;
import com.e2edour.common.bean.Page;

/**
 * Created by King on 2015/11/26.
 */
public interface EaasyManagerFacade {

    public CommonResponse addUncheckedEaasy(UncheckedEaasyBO uncheckedEaasyBO);

    public CommonResponse queryUncheckedEaasyForOne(UncheckedEaasyBO uncheckedEaasyBO);

    public CommonResponse verifyUncheckedEaasy(String[] ids, String status);

    public Page<UncheckedEaasyBO> queryUnCheckedEaasyForPage(Page page,UncheckedEaasyBO uncheckedEaasyBO);

    public Page<CheckedEaasyBO> queryCheckedEaasyForPage(Page page,CheckedEaasyBO checkedEaasyBO);
}
