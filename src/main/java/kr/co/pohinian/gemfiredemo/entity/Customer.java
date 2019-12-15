/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package kr.co.pohinian.gemfiredemo.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.gemfire.mapping.annotation.Region;

import java.io.Serializable;

@Data
@ToString
@Region("customer")
@NoArgsConstructor
@RequiredArgsConstructor(staticName = "newCustomer")
public class Customer implements Serializable {
    @Id
    @NonNull
    @Getter
    private Long id;
    @NonNull
    @Getter
    private String name;

}
