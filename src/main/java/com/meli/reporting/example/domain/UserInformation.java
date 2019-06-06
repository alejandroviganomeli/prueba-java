package com.meli.reporting.example.domain;

public class UserInformation {

    private Long id;
    private String identificationType;
    private String firstName;
    private String lastName;
    private String identificationNumber;

    public UserInformation(Builder builder) {
        this.id = builder.id;
        this.identificationType = builder.identificationType;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.identificationNumber = builder.identificationNumber;
    }

    public Long getId() {
        return id;
    }

    public String getIdentificationType() {
        return identificationType;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getIdentificationNumber() {
        return identificationNumber;
    }


    static final class Builder {
        private Long id;
        private String identificationType;
        private String firstName;
        private String lastName;
        private String identificationNumber;

        public Builder withId(Long id) {
            this.id = id;
            return this;
        }

        public Builder withIdentificationType(String identificationType) {
            this.identificationType = identificationType;
            return this;
        }

        public Builder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder withLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder withIdentificationNumber(String identificationNumber) {
            this.identificationNumber = identificationNumber;
            return this;
        }

        public UserInformation build() {
            return new UserInformation(this);
        }
    }
}
