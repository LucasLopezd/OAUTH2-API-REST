package com.api.notes.exception;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserNotFoundException extends NotFoundException{
    
    private String message;

}
