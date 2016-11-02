package br.com.restfulSmartFier.factory;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

public class Mqtt {

	public static Mqtt mqtt;

	private Mqtt() {

	}

	public static Mqtt getIntancia() {
		if (mqtt == null) {
			return new Mqtt();
		} else {
			return mqtt;
		}

	}

	private boolean retorno = false;

	public boolean isOnline(String estacaoId) {
		retorno = false;
		MqttClient mqttC;
		try {
			mqttC = new MqttClient("tcp://nachos.ftp.sh:1883",
					MqttClient.generateClientId(), new MemoryPersistence());
			mqttC.connect();

			mqttC.setCallback(new MqttCallback() {

				@Override
				public void connectionLost(Throwable cause) {
				}

				@Override
				public void messageArrived(String topic, MqttMessage message)
						throws Exception {
					String re = new String(message.getPayload(), "UTF-8");
					String g = estacaoId + "!";
					// System.out.println("-------------------------------------");
					// System.out.println(re + "-----------------");
					// System.out.println(g);
					// System.out.println(re==g);
					// System.out.println(re.equals(g));

					if (re.equals(g)) {
						System.out.println("ONLINE");
						retorno = true;
					}

					// System.out.println(re);

					// System.out.println(topic + ": " +
					// Arrays.toString(message.getPayload()));
				}

				@Override
				public void deliveryComplete(IMqttDeliveryToken token) {// Called
																		// when
																		// a
				}
			});

			mqttC.subscribe("broadcast");
			String menssagem = estacaoId + "?";
			mqttC.publish("broadcast", // topic
					menssagem.getBytes(), // payload
					2, // QoS
					false);

			int x = 0;
			while (x < 6) {
				Thread.sleep(1000);
				if (retorno == true) {
					break;
				}
				x++;
			}
			// System.out.println("pegou na moral");
		} catch (MqttException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("retorno + " + retorno);

		return retorno;

	}

}
