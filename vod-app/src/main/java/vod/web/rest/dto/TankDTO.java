package vod.web.rest.dto;

import lombok.Data;
import vod.model.Platoon;
import vod.model.Tanker;

import java.util.List;

@Data
public class TankDTO {
    private String name;
    private List<Tanker> tankers;
    private Platoon platoon;
}
