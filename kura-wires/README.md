The initial version of the PPMP Wire Component for Eclipse Kura supports a subset of the PPMP specification. With the beta release, only basic measurement messages are supported. Follow the below instructions to try the PPMP Wire Component.

- Install Eclipse Kura v3.1.0
- Install any of the Kura Driver Wire components that fit your application. The available drivers include Modbus, OPC-UA, S7, BLE
- Install the Kura PPMP Wire Component deployment package found [here](https://raw.githubusercontent.com/eclipselabs/master/eclipseiot-testbed-productionperformancemanagement/kura-ppmp.dp)
- Add a Timer, Driver, and PPMP Wire component to your Wire Graph

 ![](https://raw.githubusercontent.com/eclipselabs/eclipseiot-testbed-productionperformancemanagement/master/kura-wires/wires-example.png)

- Select the Driver and add channels for the measurements that will be sent to the PPMP component

 ![](https://raw.githubusercontent.com/eclipselabs/eclipseiot-testbed-productionperformancemanagement/master/kura-wires/driver-configuration.png)

- Select the PPMP component and enter information for publishing
  - ppmp.poll.interval – The number of Kura Wires Timer intervals to wait before publishing collected data
  - ppmp.rest.measurement.url – Complete URL for the REST endpoint
- Select the PPMP component and enter the JSON PPMP configuration. This JSON configuration maps the channel names and other information to the PPMP component. The below JSON example shows the features currently available in the first release of the Kura PPMP Wire Component. Note, the &quot;$&quot; character can be used to map channel names from the Driver to the PPMP component (ex: $DriverChannelName)

```json
{
  "mm": [
    {
      "device": {
        "deviceId": "3d48b86e-2d76-4cc0-9e35-6fe978dc13a1"
      },
      "part": {
        "partId": "c4735f9c-363e-4dff-9880-d572b277931e"
      },
      "measurements": {
        "series": [
          { "seriesNames": ["$Torq", "$TorqTemp"] },
          { "seriesNames": ["$Pressure"] }
        ]
      }
    },
    {
      "device": {
        "deviceId": "dd6bfc64-2abd-4108-8c2c-854593dc5b20"
      },
      "part": {
        "partId": "315fc148-08a6-48a5-ae9d-bf30ad50cb39"
      },
      "measurements": {
        "series": [
          { "seriesNames": ["$Vibration", "$VibTemp"] }
        ]
      }
    }
  ]
}
```

- The above JSON configuration will result in the below PPMP JSON payload for use with a PPMP compatible server


```json
[
    {
        "content-spec": "urn:spec://eclipse.org/unide/measurement-message#v2",
        "device": {
            "deviceID": "3d48b86e-2d76-4cc0-9e35-6fe978dc13a1"
        },
        "measurements": [
            {
                "ts": "2017-10-19T13:17:30-07:00",
                "series": {
                    "$_time": [
                        0,
                        10011,
                        20009,
                        30011,
                        40009
                    ],
                    "$TorqTemp": [
                        19.710001945495605,
                        23.712000846862793,
                        17.005000114440918,
                        17.71199941635132,
                        16.382999420166016
                    ],
                    "$Torq": [
                        198.18794920357564,
                        207.23787169315202,
                        190.47977206665246,
                        190.08858424913728,
                        192.36339634306935
                    ]
                }
            },
            {
                "ts": "2017-10-19T13:17:30-07:00",
                "series": {
                    "$Pressure": [
                        996.3758984071513,
                        1014.475743386304,
                        980.9595441333049,
                        980.1771684982746,
                        984.7267926861388
                    ],
                    "$_time": [
                        0,
                        10005,
                        20003,
                        30005,
                        40003
                    ]
                }
            }
        ]
    },
    {
        "content-spec": "urn:spec://eclipse.org/unide/measurement-message#v2",
        "device": {
            "deviceID": "dd6bfc64-2abd-4108-8c2c-854593dc5b20"
        },
        "measurements": [
            {
                "ts": "2017-10-19T13:17:30-07:00",
                "series": {
                    "$VibTemp": [
                        19.42000389099121,
                        27.424001693725586,
                        14.010000228881836,
                        15.423998832702637,
                        12.765998840332031
                    ],
                    "$_time": [
                        0,
                        10009,
                        20007,
                        30009,
                        40007
                    ],
                    "$Vibration": [
                        90.93974601787824,
                        136.18935846576005,
                        52.398860333262355,
                        50.44292124568645,
                        61.81698171534679
                    ]
                }
            }
        ]
    }
]
```
}