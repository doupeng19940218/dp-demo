package org.example;

import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

/**
 * @author walker.dou
 */
public class jdbc {


    @SneakyThrows
    public static void main(String[] args) {
        for (int i = 0; i < 100_000; i++) {
            exec();
        }
    }

    private static void exec() throws SQLException {
        String url = "jdbc:mysql://10.80.90.11:3308/platform-crm?useSSL=false";
        String username = "root";
        String password = "TBqCud";
        String sql = "SELECT USER();\n" +
                "select count(*) from DATABASECHANGELOG;\n" +
                "SELECT LOCKED FROM DATABASECHANGELOGLOCK WHERE ID=1;\n" +
                "UPDATE DATABASECHANGELOGLOCK SET LOCKED = 1, LOCKEDBY = 'FCO-3676 (10.88.117.42)', LOCKGRANTED = '2023-11-29 11:19:45.072' WHERE ID = 1 AND LOCKED = 0;\n" +
                "SHOW FULL COLUMNS FROM `crm_activity` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_activity_file` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_activity_group` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_activity_push` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_activity_push_record` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_activity_record` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_activity_time` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_activity_type` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_area` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_assemble_relation` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_automatic_tag` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_automatic_tag_type` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_award_config` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_award_config_batch` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_award_config_batch_code` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_award_config_channel` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_award_config_log` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_award_config_product` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_award_rated_record` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_bn_service_record` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_buy_record_area_material_stat` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_buy_record_area_material_stat_detail` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_buy_record_area_material_stat_hour_detail` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_buy_record_area_stat` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_buy_record_area_stat_detail` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_buy_record_area_stat_hour_detail` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_buy_record_original_order_operate_log` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_buy_record_original_product_bind` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_buy_record_original_product_bind_item` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_buy_record_original_product_bind_log` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_buy_record_original_taobao_order` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_buy_record_original_taobao_order_item` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_buy_record_original_taobao_order_stat` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_cc_cs_staff_rest` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_cc_ip_phone` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_cc_route_product` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_cc_service_result_relation` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_cc_service_type_relation` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_chat_record` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_chat_record_heduohao` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_chat_record_heli` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_chat_record_out_company` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_chat_record_qialuo_ftp_anchor` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_chat_record_qimo` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_collect_coupon_record` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_conf_net_info` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_config` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_coupon` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_coupon_grant_record` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_coupon_remind_record` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_coupon_type` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_cs_order_tag` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_cs_organization` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_cs_service` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_cs_service_detail` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_cs_service_detail_repair` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_cs_service_detail_robot_fault` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_cs_service_file` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_cs_service_log` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_cs_service_tag` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_cs_staff` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_cs_staff_process_order_info` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_cs_staff_tag` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_cs_staff_weight` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_cs_staff_weight_channel_record` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_cs_staff_weight_channel_record_detail` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_cs_staff_weight_channel_record_log` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_cs_staff_weight_rule` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_cs_staff_weight_rule_detail` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_cs_staff_weight_rule_log` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_cs_tag` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_cs_tool` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_cs_tool_relation` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_customer_account` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_customer_assemble` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_customer_automatic_tag` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_customer_automatioc_tag` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_customer_automatioc_tag_1` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_customer_automatioc_tag_10` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_customer_automatioc_tag_11` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_customer_automatioc_tag_12` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_customer_automatioc_tag_13` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_customer_automatioc_tag_14` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_customer_automatioc_tag_15` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_customer_automatioc_tag_16` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_customer_automatioc_tag_17` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_customer_automatioc_tag_18` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_customer_automatioc_tag_19` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_customer_automatioc_tag_2` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_customer_automatioc_tag_20` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_customer_automatioc_tag_21` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_customer_automatioc_tag_22` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_customer_automatioc_tag_23` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_customer_automatioc_tag_24` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_customer_automatioc_tag_25` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_customer_automatioc_tag_26` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_customer_automatioc_tag_27` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_customer_automatioc_tag_28` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_customer_automatioc_tag_29` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_customer_automatioc_tag_3` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_customer_automatioc_tag_30` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_customer_automatioc_tag_31` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_customer_automatioc_tag_32` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_customer_automatioc_tag_33` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_customer_automatioc_tag_34` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_customer_automatioc_tag_35` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_customer_automatioc_tag_36` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_customer_automatioc_tag_37` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_customer_automatioc_tag_38` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_customer_automatioc_tag_39` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_customer_automatioc_tag_4` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_customer_automatioc_tag_40` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_customer_automatioc_tag_41` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_customer_automatioc_tag_42` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_customer_automatioc_tag_43` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_customer_automatioc_tag_44` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_customer_automatioc_tag_45` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_customer_automatioc_tag_46` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_customer_automatioc_tag_47` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_customer_automatioc_tag_48` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_customer_automatioc_tag_49` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_customer_automatioc_tag_5` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_customer_automatioc_tag_50` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_customer_automatioc_tag_6` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_customer_automatioc_tag_7` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_customer_automatioc_tag_8` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_customer_automatioc_tag_9` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_customer_basics_info` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_customer_buy_record` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_customer_buy_record_goods` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_customer_buy_record_goods_sn` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_customer_chat` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_customer_collection` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_customer_collection_big_data` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_customer_collection_category` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_customer_collection_import_detail` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_customer_collection_log` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_customer_collection_result_detail` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_customer_collection_rule` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_customer_collection_rule_detail` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_customer_collection_sa` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_customer_collection_sample_detail` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_customer_collection_tag_sum` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_customer_consume_record` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_customer_consumption_amount` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_customer_contacts` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_customer_deed_log` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_customer_filte_option` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_customer_filter_rule` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_customer_generated_record` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_customer_group` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_customer_house_info` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_customer_import` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_customer_latest_merge_record` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_customer_list_log` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_customer_operation_log` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_customer_product` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_customer_property` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_customer_proposal` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_customer_proposal_operate_log` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_customer_push_record` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_customer_question_feedback` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_customer_question_feedback_file` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_customer_question_feedback_operate_log` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_customer_rated` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_customer_relationship` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_customer_robot_conf_net_record` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_customer_service_words` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_customer_service_words_category` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_customer_tag` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_customer_wash_group` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_customer_wash_group_log` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_customer_wx_info` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_dictionary_channel` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_dictionary_channel_mainKeys` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_dictionary_cs_tool` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_dictionary_mobile_area` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_dictionary_product` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_dictionary_product_category` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_dictionary_question` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_dictionary_question_category` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_dictionary_service_type` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_dictionary_short_url_config` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_dictionary_short_url_config_log` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_dictionary_user_robot_fault` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_dw_customer_info` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_eco_robot_fault_notice` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_export_record` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_file_attach` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_first_net_record` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_fixed_remind` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_fixed_remind_config` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_fixed_remind_config_operation_log` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_fixed_remind_config_sms` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_fixed_remind_config_wechat` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_fixed_remind_operation_log` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_fixed_remind_record` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_fixed_remind_trigger` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_goods_fixed_remind` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_goods_fixed_remind_config` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_goods_fixed_remind_config_app` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_goods_fixed_remind_config_sms` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_goods_fixed_remind_config_wechat` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_goods_fixed_remind_record` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_import_record` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_juphoon_group_report` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_juphoon_staff_daily_report` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_juphoon_staff_report` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_knowledge_activity` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_knowledge_activity_item` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_knowledge_activity_item_customer` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_knowledge_activity_item_customer_log` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_knowledge_activity_item_log` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_knowledge_activity_item_wise_man` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_knowledge_activity_log` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_knowledge_activity_order_relation` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_list_classify` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_list_management` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_manual_tag` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_manual_tag_type` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_map_area_mapping` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_order` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_order_channel_gds_config` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_order_file` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_order_gds_config` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_order_gds_product_config` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_order_log` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_order_oms_item` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_order_original` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_order_product_channel_relation_config` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_product_breakdown` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_product_breakdown_checking_result` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_product_breakdown_checking_step` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_product_coupon_type` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_product_fixed_remind` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_product_fixed_remind_config` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_product_fixed_remind_config_operation_log` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_product_fixed_remind_config_sms` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_product_fixed_remind_config_wechat` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_product_knowledge_base` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_product_knowledge_base_log` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_product_quality_assurance` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_product_question` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_product_question_evaluate_record` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_product_question_keyword` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_product_relation_jd_sku` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_product_return_exchange_rule` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_product_tips` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_product_tips_relation` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_promotion_activity_info` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_promotion_activity_type` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_promotion_operation_log` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_promotion_plan` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_promotion_plan_app` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_promotion_plan_import_data` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_promotion_plan_mms` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_promotion_plan_mms_item` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_promotion_plan_push_record` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_promotion_plan_push_record_2023` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_promotion_plan_sms` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_promotion_plan_wechat` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_promotion_user_variable` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_properties` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_proposal_improve` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_proposal_improve_category` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_proposal_improve_operate_log` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_proposal_improve_process_detail` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_push_analyse_conf` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_push_analyse_result` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_push_analyse_result_factor` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_push_preview` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_qianniu_customer_info` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_rated_analysis_advantage` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_rated_analysis_result` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_rated_analysis_service_module` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_rated_analysis_short_cause` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_rated_analysis_short_cause_detail` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_rated_attention` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_rated_file` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_rated_get_record` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_rated_info` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_rated_operator_log` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_rated_product` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_rated_service_module` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_rated_short_cause` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_receive_goods_notice` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_recommend_nps` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_recommend_nps_log` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_recommend_nps_tag` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_recommend_tag` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_repair_notice` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_report_consultation_all` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_report_consultation_before_sale` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_report_customer_info` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_report_customer_info_detail` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_robot_callout_biaobei_record` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_robot_callout_biaobei_task` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_robot_callout_biaobei_task_record` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_robot_conf_net_failure` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_robot_fault_notice` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_robot_fault_notice_item` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_robot_silent_notice` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_robot_use_analysis` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_service_record` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_service_record_before_deal_snapshot` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_service_record_detail_after_sale` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_service_record_detail_associator` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_service_record_detail_before_sale` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_service_record_detail_complain` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_service_record_detail_other` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_service_record_detail_real_robot_fault` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_service_record_detail_receive` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_service_record_detail_repair` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_service_record_detail_robot_fault` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_service_record_detail_urge_rate` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_service_record_detail_urge_rate_product` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_service_record_file` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_service_record_ignore_history` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_service_record_log` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_service_record_sms` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_service_record_tag` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_sharding_table_config` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_sms_template` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_staff_generate_url_log` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_taobao_account_uid_relation` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_task` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_task_history` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_task_log` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_urge_rated_config` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_urge_rated_config_operation_log` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_urge_rated_product_config` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_urge_rated_record` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_urge_rated_sms_target_library` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_urge_rated_sms_template` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_video_chat_record_juphoon` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_work_order` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_work_order_appointment` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_work_order_appointment_file` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_work_order_appointment_operate_log` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_work_order_auto_allot_rule` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_work_order_auto_allot_rule_detail` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_work_order_bind_relation` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_work_order_original_urge_rate` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_work_order_original_urge_rate_item` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_work_order_result_record` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_work_order_todo_list` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_work_order_urge_rate_config` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_wx_pull_user_list` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_wx_template_dictionary` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_wx_user_area` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_wx_user_collection` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_wx_user_collection_result` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_wx_user_collection_rule` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_wx_user_collection_sample` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_wx_user_full_data` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `crm_wx_user_info` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `DATABASECHANGELOG` FROM `platform-crm` LIKE '%';\n" +
                "SHOW FULL COLUMNS FROM `DATABASECHANGELOGLOCK` FROM `platform-crm` LIKE '%';\n" +
                "SELECT MD5SUM FROM DATABASECHANGELOG WHERE MD5SUM IS NOT NULL;\n" +
                "SELECT FILENAME,AUTHOR,ID,MD5SUM,DATEEXECUTED,ORDEREXECUTED,EXECTYPE,DESCRIPTION,COMMENTS,TAG,LIQUIBASE FROM DATABASECHANGELOG ORDER BY DATEEXECUTED ASC, ORDEREXECUTED ASC;\n" +
                "UPDATE DATABASECHANGELOGLOCK SET LOCKED = 0, LOCKEDBY = NULL, LOCKGRANTED = NULL WHERE ID = 1;\n";

        Connection connection1 = DriverManager.getConnection(url, username, password);
        Statement statement = connection1.createStatement();
        connection1.setAutoCommit(true);//开启事务
        final String[] split = sql.split("\n");
        Arrays.asList(split).forEach(sql2 -> {
            try {
                statement.execute(sql2);
                System.out.println(sql2);
            } catch (Exception e) {
                System.err.println(sql2);
            }
        });
    }
}
