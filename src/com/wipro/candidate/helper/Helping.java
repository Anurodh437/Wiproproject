package com.wipro.candidate.helper;

import com.wipro.candidate.bean.CandidateBean;

public class Helping {
    public boolean checker(){
        CandidateBean candBean = new CandidateBean();
        boolean find = true;
            if (candBean.getName().length() < 2 || (candBean.getM1()>=0 && candBean.getM1()<=100) ||(candBean.getM2()>=0 && candBean.getM2()<=100) || (candBean.getM3()>=0 && candBean.getM3()<=100)){
                find = false;
            }
            else
                find = true;
     return find;
    }

}
