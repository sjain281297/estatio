package org.estatio.capex.dom.util;

import java.util.List;

import org.assertj.core.util.Lists;

public class InvoicePageRange {

    private InvoicePageRange(){}

    public static List<Integer> firstPageChoices() {
        return Lists.newArrayList(1,2,3,4,5,10,20,50);
    }
    public static List<Integer> lastPageChoices() {
        return Lists.newArrayList(0,1,2,3,4,5,10,20,50);
    }

}
