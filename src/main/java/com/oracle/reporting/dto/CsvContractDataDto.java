package com.oracle.contractportfolio.dto;

public class CsvContractDataDto {

    private Long customerId;

    private Long contractId;

    private String geozone;

    private String teamcode;

    private String projectcode;

    private Long buildduration;

    public CsvContractDataDto() {}

    public CsvContractDataDto(Long customerId, Long contractId, String geozone,
                              String teamcode, String projectcode, Long buildduration) {

        this.customerId = customerId;
        this.contractId = contractId;
        this.geozone = geozone;
        this.teamcode = teamcode;
        this.projectcode = projectcode;
        this.buildduration = buildduration;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public Long getContractId() {
        return contractId;
    }

    public String getGeozone() {
        return geozone;
    }

    public String getTeamcode() {
        return teamcode;
    }

    public String getProjectcode() {
        return projectcode;
    }

    public Long getBuildduration() {
        return buildduration;
    }
}
