package com.example.jgarciaponce.mysosapp;

import com.salesforce.android.sos.api.Sos;
import com.salesforce.android.sos.api.SosConfiguration;
import com.salesforce.android.sos.api.SosOptions;

/**
 * Created by jgarciaponce on 27/01/2016.
 */
public class SOSHandler {

    public void startSos (String endpoint,
                          String orgId,
                          String deploymentId,
                          String email,
                          MyActivity activity) {

        SosOptions options = new SosOptions(
                email,
                endpoint,
                orgId,
                deploymentId
        );
        SosConfiguration config = SosConfiguration.builder()
                .twoWayVideo(true)
                .hotCorners(true)
                .build();

        // add SosConfiguration to the SessionBuilder
        Sos.session(options)
                .configuration(config)
                .start(activity);
    }
}

