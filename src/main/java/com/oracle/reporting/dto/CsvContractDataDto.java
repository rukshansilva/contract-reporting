package com.oracle.reporting.dto;

/**
 * CSV Contract data transfer object
 *
 * @author Rukshan Silva
 * @since 1.0
 */
public class CsvContractDataDto {

    private Long customerId;

    private Long contractId;

    private String geozone;

    private String teamcode;

    private String projectcode;

    private Double buildduration;

    public static CsvContractDataDto builder() {
        return new CsvContractDataDto();
    }

    public CsvContractDataDto customerId(Long customerId) {
        this.customerId = customerId;
        return this;
    }

    public CsvContractDataDto contractId(Long contractId) {
        this.contractId = contractId;
        return this;
    }

    public CsvContractDataDto geozone(String geozone) {
        this.geozone = geozone;
        return this;
    }

    public CsvContractDataDto teamcode(String teamcode) {
        this.teamcode = teamcode;
        return this;
    }

    public CsvContractDataDto projectcode(String projectcode) {
        this.projectcode = projectcode;
        return this;
    }

    public CsvContractDataDto buildduration(Double buildduration) {
        this.buildduration = buildduration;
        return this;
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

    public Double getBuildduration() {
        return buildduration;
    }

}
