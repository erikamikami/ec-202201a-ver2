package com.example.ecommerce_a.domain.model;

import javax.validation.GroupSequence;

/**
 * バリデーション グループ実行順を決めるインターフェイス.
 * 
 * @author mikami
 *
 */
@GroupSequence({ ValidGroup1.class, ValidGroup2.class})
public interface GroupOrder {

}
