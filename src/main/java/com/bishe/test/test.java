package com.bishe.test;

public class test {
    public static void main(String[] args) {
        String t = "select (select  inst.inst_id_ from BPM_INST inst  where inst.bus_key_ = (select id_ from gw_form f where f.id_number = t.id_ and rownum =1))instid," +
                "nvl((select decode(inst.status_,'SUCCESS_END',1,'RUNNING',2,0)  from BPM_INST inst  where inst.bus_key_ = (select id_ from gw_form f where f.id_number = t.id_ and rownum =1)),0)i_status_," +
                " t.id_,t.ref_id_,t.parent_id_,t.county_name,t.id,t.batch_id,t.area_code,t.dept_id,t.dept_name,t.official_act,t.received_unit,t.reception_time,t.meal_time,t.city_id,t.city_name,t.county_id," +
                "t.town_id,t.town_name,t.reception_address,t.guests_num,t.invoice,t.submission_list,t.official_letter,t.menu,t.create_by,t.create_time,t.update_by,t.update_time,t.data_source," +
                "t.src_sys,t.src_sys_data_id,t.year,t.is_canteen,t.main_guests,t.guests_num+t.our_num as our_num,t.our_accompany,t.total_people,t.highest_job,t.cost_money,t.reason,t.invoice_handler,t.acquisition_time," +
                "t.tax_invoice_code,t.tax_invoice_number,t.inst_id_,t.inst_status_,t.create_user_id_,t.create_group_id_,t.tenant_id_,t.create_time_,t.update_time_,t.kpdwtyshxydms,t.is_canteen_names,t.highest_jobs_name," +
                "t.meal_time_names,t.official_acts_name,t.yearandmonth,t.process_status,t.tsrget_status,t.open_status,t.open_status_name,t.target_status,t.update_user_id,t.user_id,t.tenants_id,t.group_id,t.recepition_code," +
                "t.other_work_guests,t.other_work_num,t.other_cost_money,t.MONEY_STANDARD,t.MONEY_OTHER_STANDARD,t.other_work_guests_list,t.main_guests_list,t.is_otherwork,t.our_accompany_list,t.QT_STANDARD ," +
                "t.is_ourpeople_standard,t.GZ_STANDARD,decode(t.OPEN_STATUS,0,'不公开',1,'外部公开',2,'内部公开',3,'暂存',4,'审核中',5,'已提交') OPEN_STATUS_CS," +
                "o.fullname_ from GW_SOURCE_OFFICIAL_DINING_BUS t left join os_user o on t.CREATE_BY =o.user_id_  left join OS_GROUP g on t.GROUP_ID=g.group_id_ where  1=1";

        if( 1 == '1' || 1 == 1){
            System.out.println(123);
        }


    }
}
