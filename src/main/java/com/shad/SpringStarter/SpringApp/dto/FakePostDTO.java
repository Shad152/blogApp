package com.shad.SpringStarter.SpringApp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FakePostDTO {
    private Long userId;
    private Long id;
    private String title;
    private String body;
    @Override
    public String toString(){
        return this.userId+" \n"+this.id+" \n"+this.title+" \n"+this.body+" \n\n\n";
    }

}
