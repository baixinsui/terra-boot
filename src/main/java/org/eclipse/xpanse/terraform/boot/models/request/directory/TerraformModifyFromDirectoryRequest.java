/*
 * SPDX-License-Identifier: Apache-2.0
 * SPDX-FileCopyrightText: Huawei Inc.
 */

package org.eclipse.xpanse.terraform.boot.models.request.directory;

import static io.swagger.v3.oas.annotations.media.Schema.AdditionalPropertiesValue.TRUE;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import lombok.Data;
import org.eclipse.xpanse.terraform.boot.terraform.TerraformVersionHelper;

/**
 * Data model for the terraform modify requests.
 */
@Data
public class TerraformModifyFromDirectoryRequest {

    @Schema(description = "Id of the request")
    UUID requestId;

    @NotNull
    @NotBlank
    @Pattern(regexp = TerraformVersionHelper.TERRAFORM_REQUIRED_VERSION_REGEX)
    @Schema(description = "The required version of the terraform which will execute the scripts.")
    String terraformVersion;

    @NotNull
    @Schema(description = "Flag to control if the deployment must only generate the terraform "
            + "or it must also apply the changes.")
    Boolean isPlanOnly;

    @NotNull
    @Schema(description = "Key-value pairs of regular variables that must be used to execute the "
            + "Terraform request.", additionalProperties = TRUE)
    Map<String, Object> variables;

    @Schema(description = "Key-value pairs of variables that must be injected as environment "
            + "variables to terraform process.", additionalProperties = TRUE)
    Map<String, String> envVariables = new HashMap<>();
}
