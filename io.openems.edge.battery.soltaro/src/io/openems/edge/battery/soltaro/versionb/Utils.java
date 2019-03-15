package io.openems.edge.battery.soltaro.versionb;

import java.util.Arrays;
import java.util.stream.Stream;

import io.openems.edge.battery.api.Battery;
import io.openems.edge.battery.soltaro.versionb.SoltaroRackVersionB;
import io.openems.edge.common.channel.AbstractReadChannel;
import io.openems.edge.common.channel.BooleanReadChannel;
import io.openems.edge.common.channel.IntegerReadChannel;
import io.openems.edge.common.channel.IntegerWriteChannel;
import io.openems.edge.common.channel.StateChannel;
import io.openems.edge.common.channel.StateCollectorChannel;
import io.openems.edge.common.component.OpenemsComponent;

public class Utils {

	public static Stream<? extends AbstractReadChannel<?>> initializeChannels(SoltaroRackVersionB s) {
		// Define the channels. Using streams + switch enables Eclipse IDE to tell us if
		// we are missing an Enum value.
		return Stream.of( //
				Arrays.stream(OpenemsComponent.ChannelId.values()).map(channelId -> {
					switch (channelId) {
					case STATE:
						return new StateCollectorChannel(s, channelId);
					}
					return null;
				}), Arrays.stream(Battery.ChannelId.values()).map(channelId -> {
					switch (channelId) {
					case SOC:
					case SOH:					
					case MIN_CELL_VOLTAGE:
					case VOLTAGE:
					case CURRENT:
					case MAX_CELL_TEMPERATURE:
					case MAX_CELL_VOLTAGE:
					case MIN_CELL_TEMPERATURE:
						return new IntegerReadChannel(s, channelId);
					case CHARGE_MAX_CURRENT:
						return new IntegerReadChannel(s, channelId, 0);
					case CHARGE_MAX_VOLTAGE:
						return new IntegerReadChannel(s, channelId);
					case DISCHARGE_MAX_CURRENT:
						return new IntegerReadChannel(s, channelId, 0);
					case DISCHARGE_MIN_VOLTAGE:
						return new IntegerReadChannel(s, channelId);
					case READY_FOR_WORKING:
						return new BooleanReadChannel(s, channelId);
					case CAPACITY:
						return new IntegerReadChannel(s, channelId);
					}
					return null;
				}), Arrays.stream(VersionBChannelId.values()).map(channelId -> {
					switch (channelId) {
					case BMS_CONTACTOR_CONTROL:
					case CELL_VOLTAGE_PROTECT:
					case CELL_VOLTAGE_RECOVER:
					case EMS_COMMUNICATION_TIMEOUT:
					case WORK_PARAMETER_PCS_COMMUNICATION_RATE:
					case AUTO_SET_SLAVES_ID:
					case AUTO_SET_SLAVES_TEMPERATURE_ID:
					case SYSTEM_RESET:

					case STOP_PARAMETER_CELL_OVER_TEMPERATURE_PROTECTION:
					case STOP_PARAMETER_CELL_OVER_TEMPERATURE_RECOVER:
					case STOP_PARAMETER_CELL_OVER_VOLTAGE_PROTECTION:
					case STOP_PARAMETER_CELL_OVER_VOLTAGE_RECOVER:
					case STOP_PARAMETER_CELL_UNDER_TEMPERATURE_PROTECTION:
					case STOP_PARAMETER_CELL_UNDER_TEMPERATURE_RECOVER:
					case STOP_PARAMETER_CELL_UNDER_VOLTAGE_PROTECTION:
					case STOP_PARAMETER_CELL_UNDER_VOLTAGE_RECOVER:
					case STOP_PARAMETER_CELL_VOLTAGE_DIFFERENCE_PROTECTION:
					case STOP_PARAMETER_CELL_VOLTAGE_DIFFERENCE_PROTECTION_RECOVER:
					case STOP_PARAMETER_CONNECTOR_TEMPERATURE_HIGH_PROTECTION:
					case STOP_PARAMETER_CONNECTOR_TEMPERATURE_HIGH_PROTECTION_RECOVER:
					case STOP_PARAMETER_DISCHARGE_TEMPERATURE_HIGH_PROTECTION:
					case STOP_PARAMETER_DISCHARGE_TEMPERATURE_HIGH_PROTECTION_RECOVER:
					case STOP_PARAMETER_DISCHARGE_TEMPERATURE_LOW_PROTECTION:
					case STOP_PARAMETER_DISCHARGE_TEMPERATURE_LOW_PROTECTION_RECOVER:
					case STOP_PARAMETER_INSULATION_PROTECTION:
					case STOP_PARAMETER_INSULATION_PROTECTION_RECOVER:
					case STOP_PARAMETER_SOC_HIGH_PROTECTION:
					case STOP_PARAMETER_SOC_HIGH_PROTECTION_RECOVER:
					case STOP_PARAMETER_SOC_LOW_PROTECTION:
					case STOP_PARAMETER_SOC_LOW_PROTECTION_RECOVER:
					case STOP_PARAMETER_SYSTEM_CHARGE_OVER_CURRENT_PROTECTION:
					case STOP_PARAMETER_SYSTEM_CHARGE_OVER_CURRENT_RECOVER:
					case STOP_PARAMETER_SYSTEM_DISCHARGE_OVER_CURRENT_PROTECTION:
					case STOP_PARAMETER_SYSTEM_DISCHARGE_OVER_CURRENT_RECOVER:
					case STOP_PARAMETER_SYSTEM_OVER_VOLTAGE_PROTECTION:
					case STOP_PARAMETER_SYSTEM_OVER_VOLTAGE_RECOVER:
					case STOP_PARAMETER_SYSTEM_UNDER_VOLTAGE_PROTECTION:
					case STOP_PARAMETER_SYSTEM_UNDER_VOLTAGE_RECOVER:
					case STOP_PARAMETER_TEMPERATURE_DIFFERENCE_PROTECTION:
					case STOP_PARAMETER_TEMPERATURE_DIFFERENCE_PROTECTION_RECOVER:
					case STOP_PARAMETER_TOTAL_VOLTAGE_DIFFERENCE_PROTECTION:
					case STOP_PARAMETER_TOTAL_VOLTAGE_DIFFERENCE_PROTECTION_RECOVER:

					case WARN_PARAMETER_SOC_HIGH_ALARM_RECOVER:
					case WARN_PARAMETER_CELL_OVER_TEMPERATURE_ALARM:
					case WARN_PARAMETER_CELL_OVER_TEMPERATURE_RECOVER:
					case WARN_PARAMETER_CELL_OVER_VOLTAGE_ALARM:
					case WARN_PARAMETER_CELL_OVER_VOLTAGE_RECOVER:
					case WARN_PARAMETER_CELL_UNDER_TEMPERATURE_ALARM:
					case WARN_PARAMETER_CELL_UNDER_TEMPERATURE_RECOVER:
					case WARN_PARAMETER_CELL_UNDER_VOLTAGE_ALARM:
					case WARN_PARAMETER_CELL_UNDER_VOLTAGE_RECOVER:
					case WARN_PARAMETER_CELL_VOLTAGE_DIFFERENCE_ALARM:
					case WARN_PARAMETER_CELL_VOLTAGE_DIFFERENCE_ALARM_RECOVER:
					case WARN_PARAMETER_CONNECTOR_TEMPERATURE_HIGH_ALARM:
					case WARN_PARAMETER_CONNECTOR_TEMPERATURE_HIGH_ALARM_RECOVER:
					case WARN_PARAMETER_DISCHARGE_TEMPERATURE_HIGH_ALARM:
					case WARN_PARAMETER_DISCHARGE_TEMPERATURE_HIGH_ALARM_RECOVER:
					case WARN_PARAMETER_DISCHARGE_TEMPERATURE_LOW_ALARM:
					case WARN_PARAMETER_DISCHARGE_TEMPERATURE_LOW_ALARM_RECOVER:
					case WARN_PARAMETER_INSULATION_ALARM:
					case WARN_PARAMETER_INSULATION_ALARM_RECOVER:
					case WARN_PARAMETER_SOC_HIGH_ALARM:
					case WARN_PARAMETER_SOC_LOW_ALARM:
					case WARN_PARAMETER_SOC_LOW_ALARM_RECOVER:
					case WARN_PARAMETER_SYSTEM_CHARGE_OVER_CURRENT_ALARM:
					case WARN_PARAMETER_SYSTEM_CHARGE_OVER_CURRENT_RECOVER:
					case WARN_PARAMETER_SYSTEM_DISCHARGE_OVER_CURRENT_ALARM:
					case WARN_PARAMETER_SYSTEM_DISCHARGE_OVER_CURRENT_RECOVER:
					case WARN_PARAMETER_SYSTEM_OVER_VOLTAGE_ALARM:
					case WARN_PARAMETER_SYSTEM_OVER_VOLTAGE_RECOVER:
					case WARN_PARAMETER_SYSTEM_UNDER_VOLTAGE_ALARM:
					case WARN_PARAMETER_SYSTEM_UNDER_VOLTAGE_RECOVER:
					case WARN_PARAMETER_TEMPERATURE_DIFFERENCE_ALARM:
					case WARN_PARAMETER_TEMPERATURE_DIFFERENCE_ALARM_RECOVER:
					case WARN_PARAMETER_TOTAL_VOLTAGE_DIFFERENCE_ALARM:
					case WARN_PARAMETER_TOTAL_VOLTAGE_DIFFERENCE_ALARM_RECOVER:
						return new IntegerWriteChannel(s, channelId);

					case ALARM_LEVEL_1_CELL_CHA_TEMP_HIGH:
					case ALARM_LEVEL_1_CELL_CHA_TEMP_LOW:
					case ALARM_LEVEL_1_CELL_DISCHA_TEMP_HIGH:
					case ALARM_LEVEL_1_CELL_DISCHA_TEMP_LOW:
					case ALARM_LEVEL_1_CELL_TEMP_DIFF_HIGH:
					case ALARM_LEVEL_1_CELL_VOLTAGE_DIFF_HIGH:
					case ALARM_LEVEL_1_CELL_VOLTAGE_HIGH:
					case ALARM_LEVEL_1_CELL_VOLTAGE_LOW:
					case ALARM_LEVEL_1_CHA_CURRENT_HIGH:
					case ALARM_LEVEL_1_DISCHA_CURRENT_HIGH:
					case ALARM_LEVEL_1_INSULATION_LOW:
					case ALARM_LEVEL_1_SOC_LOW:
					case ALARM_LEVEL_1_TOTAL_VOLTAGE_DIFF_HIGH:
					case ALARM_LEVEL_1_TOTAL_VOLTAGE_HIGH:
					case ALARM_LEVEL_1_TOTAL_VOLTAGE_LOW:
					case ALARM_LEVEL_1_POLE_TEMPERATURE_TOO_HIGH:

					case ALARM_LEVEL_2_CELL_VOLTAGE_DIFFERENCE_HIGH:
					case ALARM_LEVEL_2_POLES_TEMPERATURE_DIFFERENCE_HIGH:
					case ALARM_LEVEL_2_SOC_LOW:
					case ALARM_LEVEL_2_TEMPERATURE_DIFFERENCE_HIGH:
					case ALARM_LEVEL_2_TOTAL_VOLTAGE_DIFFERENCE_HIGH:
					case ALARM_LEVEL_2_CELL_CHA_TEMP_HIGH:
					case ALARM_LEVEL_2_CELL_CHA_TEMP_LOW:
					case ALARM_LEVEL_2_CELL_DISCHA_TEMP_HIGH:
					case ALARM_LEVEL_2_CELL_DISCHA_TEMP_LOW:
					case ALARM_LEVEL_2_CELL_VOLTAGE_HIGH:
					case ALARM_LEVEL_2_CELL_VOLTAGE_LOW:
					case ALARM_LEVEL_2_CHA_CURRENT_HIGH:
					case ALARM_LEVEL_2_DISCHA_CURRENT_HIGH:
					case ALARM_LEVEL_2_INSULATION_LOW:
					case ALARM_LEVEL_2_TOTAL_VOLTAGE_HIGH:
					case ALARM_LEVEL_2_TOTAL_VOLTAGE_LOW:

					case FAILURE_BALANCING_MODULE:
					case FAILURE_CONNECTOR_WIRE:
					case FAILURE_EEPROM:
					case FAILURE_INITIALIZATION:
					case FAILURE_INTRANET_COMMUNICATION:
					case FAILURE_LTC6803:
					case FAILURE_SAMPLING_WIRE:
					case FAILURE_TEMP_SAMPLING:
					case FAILURE_TEMP_SAMPLING_LINE:
					case FAILURE_TEMP_SENSOR:
					case FAILURE_VOLTAGE_SAMPLING:
					case FAILURE_GR_T:
					case FAILURE_PCB:

					case PRECHARGE_TAKING_TOO_LONG:

					case ALARM_FLAG_STATUS_CELL_LOW_TEMPERATURE:
					case ALARM_FLAG_STATUS_CELL_LOW_VOLTAGE:
					case ALARM_FLAG_STATUS_CELL_OVER_TEMPERATURE:
					case ALARM_FLAG_STATUS_CELL_OVER_VOLTAGE:
					case ALARM_FLAG_STATUS_CELL_VOLTAGE_DIFFERENCE:
					case ALARM_FLAG_STATUS_CHARGE_OVER_CURRENT:
					case ALARM_FLAG_STATUS_DISCHARGE_OVER_CURRENT:
					case ALARM_FLAG_STATUS_DISCHARGE_TEMPERATURE_HIGH:
					case ALARM_FLAG_STATUS_DISCHARGE_TEMPERATURE_LOW:
					case ALARM_FLAG_STATUS_ELECTRODE_TEMPERATURE_HIGH:
					case ALARM_FLAG_STATUS_INSULATION_LOW:
					case ALARM_FLAG_STATUS_SOC_LOW:
					case ALARM_FLAG_STATUS_SYSTEM_LOW_VOLTAGE:
					case ALARM_FLAG_STATUS_SYSTEM_OVER_VOLTAGE:
					case ALARM_FLAG_STATUS_TEMPERATURE_DIFFERENCE:
					case ALARM_FLAG_STATUS_VOLTAGE_DIFFERENCE:

					case PROTECT_FLAG_STATUS_CELL_LOW_TEMPERATURE:
					case PROTECT_FLAG_STATUS_CELL_LOW_VOLTAGE:
					case PROTECT_FLAG_STATUS_CELL_OVER_TEMPERATURE:
					case PROTECT_FLAG_STATUS_CELL_OVER_VOLTAGE:
					case PROTECT_FLAG_STATUS_CELL_VOLTAGE_DIFFERENCE:
					case PROTECT_FLAG_STATUS_CHARGE_OVER_CURRENT:
					case PROTECT_FLAG_STATUS_DISCHARGE_OVER_CURRENT:
					case PROTECT_FLAG_STATUS_DISCHARGE_TEMPERATURE_HIGH:
					case PROTECT_FLAG_STATUS_DISCHARGE_TEMPERATURE_LOW:
					case PROTECT_FLAG_STATUS_ELECTRODE_TEMPERATURE_HIGH:
					case PROTECT_FLAG_STATUS_INSULATION_LOW:
					case PROTECT_FLAG_STATUS_SOC_LOW:
					case PROTECT_FLAG_STATUS_SYSTEM_LOW_VOLTAGE:
					case PROTECT_FLAG_STATUS_SYSTEM_OVER_VOLTAGE:
					case PROTECT_FLAG_STATUS_TEMPERATURE_DIFFERENCE:
					case PROTECT_FLAG_STATUS_VOLTAGE_DIFFERENCE:

					case SLAVE_1_COMMUNICATION_ERROR:
					case SLAVE_2_COMMUNICATION_ERROR:
					case SLAVE_3_COMMUNICATION_ERROR:
					case SLAVE_4_COMMUNICATION_ERROR:
					case SLAVE_5_COMMUNICATION_ERROR:
					case SLAVE_6_COMMUNICATION_ERROR:
					case SLAVE_7_COMMUNICATION_ERROR:
					case SLAVE_8_COMMUNICATION_ERROR:
					case SLAVE_9_COMMUNICATION_ERROR:
					case SLAVE_10_COMMUNICATION_ERROR:
					case SLAVE_11_COMMUNICATION_ERROR:
					case SLAVE_12_COMMUNICATION_ERROR:
					case SLAVE_13_COMMUNICATION_ERROR:
					case SLAVE_14_COMMUNICATION_ERROR:
					case SLAVE_15_COMMUNICATION_ERROR:
					case SLAVE_16_COMMUNICATION_ERROR:
					case SLAVE_17_COMMUNICATION_ERROR:
					case SLAVE_18_COMMUNICATION_ERROR:
					case SLAVE_19_COMMUNICATION_ERROR:
					case SLAVE_20_COMMUNICATION_ERROR:

						return new StateChannel(s, channelId);

					case CLUSTER_1_VOLTAGE:
					case CLUSTER_1_CURRENT:
					case CLUSTER_1_CHARGE_INDICATION:
					case CLUSTER_1_SOH:
					case CLUSTER_RUN_STATE:
					case SYSTEM_INSULATION:
					case SYSTEM_MAX_CHARGE_CURRENT:
					case SYSTEM_MAX_DISCHARGE_CURRENT:

					case CLUSTER_1_MIN_CELL_TEMPERATURE:
					case CLUSTER_1_MAX_CELL_TEMPERATURE:
					case CLUSTER_1_MAX_CELL_TEMPERATURE_ID:
					case CLUSTER_1_MAX_CELL_VOLTAGE:
					case CLUSTER_1_MAX_CELL_VOLTAGE_ID:
					case CLUSTER_1_MIN_CELL_TEMPERATURE_ID:
					case CLUSTER_1_MIN_CELL_VOLTAGE:
					case CLUSTER_1_MIN_CELL_VOLTAGE_ID:
					
					case ALARM_FLAG_REGISTER_1_CELL_OVER_VOLTAGE:
					case ALARM_FLAG_REGISTER_1_CELL_VOLTAGE_LOW:
					case ALARM_FLAG_REGISTER_1_CHARGE_OVER_CURRENT:
					case ALARM_FLAG_REGISTER_1_DISCHARGE_OVER_CURRENT:
					case ALARM_FLAG_REGISTER_1_SYSTEM_OVER_VOLTAGE:
					case ALARM_FLAG_REGISTER_1_SYSTEM_VOLTAGE_LOW:
					case ALARM_FLAG_REGISTER_1_TEMPERATURE_HIGH:
					case ALARM_FLAG_REGISTER_1_TEMPERATURE_LOW:
					case ALARM_FLAG_REGISTER_2_CELL_VOLTAGE_DIFFERENCE:
					case ALARM_FLAG_REGISTER_2_POLE_TEMPERATURE_HIGH:
					case ALARM_FLAG_REGISTER_2_POLE_TEMPERATURE_LOW:
					case ALARM_FLAG_REGISTER_2_SOC_HIGH:
					case ALARM_FLAG_REGISTER_2_SOC_LOW:

					case BATTERY_CHARGE_OVER_CURRENT_ALARM_TIMES:
					case BATTERY_CHARGE_OVER_CURRENT_STOP_TIMES:
					case BATTERY_DISCHARGE_OVER_CURRENT_ALARM_TIMES:
					case BATTERY_DISCHARGE_OVER_CURRENT_STOP_TIMES:
					case BATTERY_OVER_TEMPERATURE_ALARM_TIMES:
					case BATTERY_OVER_TEMPERATURE_STOP_TIMES:
					case BATTERY_OVER_VOLTAGE_ALARM_TIMES:
					case BATTERY_OVER_VOLTAGE_STOP_TIMES:
					case BATTERY_TEMPERATURE_LOW_ALARM_TIMES:
					case BATTERY_TEMPERATURE_LOW_STOP_TIMES:
					case BATTERY_VOLTAGE_DIFFERENCE_ALARM_TIMES:
					case BATTERY_VOLTAGE_DIFFERENCE_STOP_TIMES:
					case BATTERY_VOLTAGE_LOW_ALARM_TIMES:
					case BATTERY_VOLTAGE_LOW_STOP_TIMES:
					case CELL_OVER_VOLTAGE_ALARM_TIMES:
					case CELL_OVER_VOLTAGE_STOP_TIMES:
					case CELL_VOLTAGE_DIFFERENCE:
					case CELL_VOLTAGE_LOW_ALARM_TIMES:
					case CELL_VOLTAGE_LOW_STOP_TIMES:
					case CURRENT_BOX_SELF_CALIBRATION:
					case CYCLE_TIME:
					case DRY_CONTACT_1_EXPORT:
					case DRY_CONTACT_2_EXPORT:
					case ENVIRONMENT_TEMPERATURE:
					case FAN_STATUS:
					case INSULATION_SENSOR_FUNCTION:
					case LAST_TIME_CHARGE_CAPACITY_LOW_BITS:
					case LAST_TIME_CHARGE_END_TIME_HIGH_BITS:
					case LAST_TIME_CHARGE_END_TIME_LOW_BITS:
					case LAST_TIME_DISCHARGE_CAPACITY_LOW_BITS:
					case LAST_TIME_DISCHARGE_END_TIME_HIGH_BITS:
					case LAST_TIME_DISCHARGE_END_TIME_LOW_BITS:
					case MAIN_CONTACTOR_FLAG:
					case MAIN_CONTACTOR_STATE:
					case MAXIMUM_CELL_VOLTAGE_NUMBER_WHEN_ALARM:
					case MAXIMUM_CELL_VOLTAGE_NUMBER_WHEN_STOPPED:
					case MAXIMUM_CELL_VOLTAGE_WHEN_ALARM:
					case MAXIMUM_CELL_VOLTAGE_WHEN_STOPPED:
					case MAX_CELL_RESISTANCE:
					case MAX_CELL_RESISTANCE_ID:
					case MINIMUM_CELL_VOLTAGE_NUMBER_WHEN_ALARM:
					case MINIMUM_CELL_VOLTAGE_NUMBER_WHEN_STOPPED:
					case MINIMUM_CELL_VOLTAGE_WHEN_ALARM:
					case MINIMUM_CELL_VOLTAGE_WHEN_STOPPED:
					case MIN_CELL_RESISTANCE:
					case MIN_CELL_RESISTANCE_ID:
					case NEGATIVE_INSULATION:
					case NUMBER_OF_TEMPERATURE_WHEN_ALARM:
					case OTHER_ALARM_EQUIPMENT_FAILURE:
					case OVER_CHARGE_CURRENT_WHEN_ALARM:
					case OVER_CHARGE_CURRENT_WHEN_STOPPED:
					case OVER_DISCHARGE_CURRENT_WHEN_ALARM:
					case OVER_DISCHARGE_CURRENT_WHEN_STOPPED:
					case OVER_VOLTAGE_VALUE_WHEN_ALARM:
					case OVER_VOLTAGE_VALUE_WHEN_STOPPED:
					case PCS_ALARM_RESET:
					case POSITIVE_INSULATION:
					case POWER_SUPPLY_VOLTAGE:
					case POWER_TEMPERATURE:
					case PRE_CONTACTOR_STATUS:
					case PROTECT_FLAG_REGISTER_1_CELL_OVER_VOLTAGE:
					case PROTECT_FLAG_REGISTER_1_CELL_VOLTAGE_LOW:
					case PROTECT_FLAG_REGISTER_1_CHARGE_OVER_CURRENT:
					case PROTECT_FLAG_REGISTER_1_DISCHARGE_OVER_CURRENT:
					case PROTECT_FLAG_REGISTER_1_SYSTEM_OVER_VOLTAGE:
					case PROTECT_FLAG_REGISTER_1_SYSTEM_VOLTAGE_LOW:
					case PROTECT_FLAG_REGISTER_1_TEMPERATURE_HIGH:
					case PROTECT_FLAG_REGISTER_1_TEMPERATURE_LOW:
					case PROTECT_FLAG_REGISTER_2_CELL_VOLTAGE_DIFFERENCE:
					case PROTECT_FLAG_REGISTER_2_POLE_TEMPERATURE_HIGH:
					case PROTECT_FLAG_REGISTER_2_POLE_TEMPERATURE_LOW:
					case PROTECT_FLAG_REGISTER_2_SOC_HIGH:
					case PROTECT_FLAG_REGISTER_2_SOC_LOW:

					case SET_EMS_ADDRESS:
					case SHORT_CIRCUIT_FUNCTION:

					case SLAVE_TEMPERATURE_COMMUNICATION_ERROR_HIGH:
					case SLAVE_TEMPERATURE_COMMUNICATION_ERROR_LOW:
					case SLEEP:
					case SOFT_SHUTDOWN:

					case SYSTEM_GR_OVER_TEMPERATURE_ALARM_TIMES:
					case SYSTEM_GR_OVER_TEMPERATURE_STOP_TIMES:

					case SYSTEM_RUN_MODE:
					case SYSTEM_SHORT_CIRCUIT_PROTECTION_TIMES:
					case SYSTEM_TIME_HIGH:
					case SYSTEM_TIME_LOW:
					case TESTING_IO:
					case TOTAL_CAPACITY_HIGH_BITS:
					case TOTAL_CAPACITY_LOW_BITS:
					case TOTAL_VOLTAGE_DIFFERENCE:
					case TRANSPARENT_MASTER:
					case UNDER_VOLTAGE_VALUE_WHEN_ALARM:
					case UNDER_VOLTAGE_VALUE_WHEN_STOPPED:
					case VOLTAGE_LOW_PROTECTION:

					case WORK_PARAMETER_CELL_AVERAGE_CHARGING:
					case WORK_PARAMETER_CELL_FLOAT_CHARGING:
					case WORK_PARAMETER_CELL_STOP_DISCHARGING:
					case WORK_PARAMETER_CURRENT_FIX_COEFFICIENT:
					case WORK_PARAMETER_CURRENT_FIX_OFFSET:
					case WORK_PARAMETER_PCS_MODBUS_ADDRESS:
					case WORK_PARAMETER_SET_CHARGER_OUTPUT_CURRENT:
					case WORK_PARAMETER_SYSTEM_CAPACITY:
					case WORK_PARAMETER_SYSTEM_RTC_TIME:
					case WORK_PARAMETER_SYSTEM_SOC:
					case WORK_PARAMETER_SYSTEM_SOH_DEFAULT_VALUE:
					case ALARM_FLAG_REGISTER_1:
					case ALARM_FLAG_REGISTER_2:
					case PROTECT_FLAG_REGISTER_1:
					case PROTECT_FLAG_REGISTER_2:
					case WORK_PARAMETER_SYSTEM_RTC_TIME_HIGH_BITS:
					case WORK_PARAMETER_SYSTEM_RTC_TIME_LOW_BITS:
					case STATE_MACHINE:
						return new IntegerReadChannel(s, channelId);					

					}
					return null;
				}) //
		).flatMap(channel -> channel);
	}
}
