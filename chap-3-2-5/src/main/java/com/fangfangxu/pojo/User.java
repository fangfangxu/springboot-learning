package com.fangfangxu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User  implements Serializable {
    private static final long serialVersionUID = -1327400249879063555L;
    private String username;
    private Integer age;

}
