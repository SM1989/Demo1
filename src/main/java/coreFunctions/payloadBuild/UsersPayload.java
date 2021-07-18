package main.java.coreFunctions.payloadBuild;

import main.java.coreFunctions.dto.UsersDto;

public class UsersPayload {

    public UsersDto getuser(String name,String job)
    {
        UsersDto dto = new UsersDto();
        dto.setName(name);
        dto.setJob(job);
        return dto;
    }
}