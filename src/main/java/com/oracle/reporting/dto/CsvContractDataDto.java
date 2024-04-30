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

    private Long buildduration;

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
