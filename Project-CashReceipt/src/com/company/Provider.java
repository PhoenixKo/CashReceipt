package com.company;

import java.util.ArrayList;
import java.util.List;

public class Provider {
    private String Name;
    private List<Goods> GoodsForSale;
    private List<Goods> soldGoods;
    private Goods good12;

    public Provider() {}

    public Provider(String Name)
    {
        this.Name = Name;
        this.GoodsForSale = new ArrayList<>();
        this.soldGoods = new ArrayList<>();
        Goods good1 = new Goods(5,"Apple", 2.30,"5/10/2019");
        Goods good2 = new Goods(561,"Dr.Otker Feliciana ", 6.15,"5/10/2020");
        Goods good3 = new Goods(3012,"Wheat Bread", 1.30,"5/6/2019");
        Goods good4 = new Goods(12,"Fanta Orange", 0.80,"12/5/2019");
        Goods good5 = new Goods(67,"Waffers", 3.30,"5/10/2019");
        GoodsForSale.add(good1);
        GoodsForSale.add(good2);
        GoodsForSale.add(good3);
        GoodsForSale.add(good4);
        GoodsForSale.add(good5);
    }

    public String getName()
    {
        return this.Name;
    }

    public void showProvderGoods()
    {
        System.out.println(GoodsForSale.toString());

    }

    public Goods getGood(int ID)
    {
        for(Goods good : GoodsForSale)
        {
            if(good.getID() == ID)
            {
                return good;
            }
        }
        return good12;
    }

    public Goods sellGood(int GoodID)
    {
        for( Goods good : GoodsForSale)
        {
            if(GoodID == good.getID())
            {
              return good;
            }

        }
        return good12;
    }

}
