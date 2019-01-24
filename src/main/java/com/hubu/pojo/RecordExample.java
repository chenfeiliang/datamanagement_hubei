package com.hubu.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RecordExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andRecordNoIsNull() {
            addCriterion("record_no is null");
            return (Criteria) this;
        }

        public Criteria andRecordNoIsNotNull() {
            addCriterion("record_no is not null");
            return (Criteria) this;
        }

        public Criteria andRecordNoEqualTo(Integer value) {
            addCriterion("record_no =", value, "recordNo");
            return (Criteria) this;
        }

        public Criteria andRecordNoNotEqualTo(Integer value) {
            addCriterion("record_no <>", value, "recordNo");
            return (Criteria) this;
        }

        public Criteria andRecordNoGreaterThan(Integer value) {
            addCriterion("record_no >", value, "recordNo");
            return (Criteria) this;
        }

        public Criteria andRecordNoGreaterThanOrEqualTo(Integer value) {
            addCriterion("record_no >=", value, "recordNo");
            return (Criteria) this;
        }

        public Criteria andRecordNoLessThan(Integer value) {
            addCriterion("record_no <", value, "recordNo");
            return (Criteria) this;
        }

        public Criteria andRecordNoLessThanOrEqualTo(Integer value) {
            addCriterion("record_no <=", value, "recordNo");
            return (Criteria) this;
        }

        public Criteria andRecordNoIn(List<Integer> values) {
            addCriterion("record_no in", values, "recordNo");
            return (Criteria) this;
        }

        public Criteria andRecordNoNotIn(List<Integer> values) {
            addCriterion("record_no not in", values, "recordNo");
            return (Criteria) this;
        }

        public Criteria andRecordNoBetween(Integer value1, Integer value2) {
            addCriterion("record_no between", value1, value2, "recordNo");
            return (Criteria) this;
        }

        public Criteria andRecordNoNotBetween(Integer value1, Integer value2) {
            addCriterion("record_no not between", value1, value2, "recordNo");
            return (Criteria) this;
        }

        public Criteria andMachineNoIsNull() {
            addCriterion("machine_no is null");
            return (Criteria) this;
        }

        public Criteria andMachineNoIsNotNull() {
            addCriterion("machine_no is not null");
            return (Criteria) this;
        }

        public Criteria andMachineNoEqualTo(String value) {
            addCriterion("machine_no =", value, "machineNo");
            return (Criteria) this;
        }

        public Criteria andMachineNoNotEqualTo(String value) {
            addCriterion("machine_no <>", value, "machineNo");
            return (Criteria) this;
        }

        public Criteria andMachineNoGreaterThan(String value) {
            addCriterion("machine_no >", value, "machineNo");
            return (Criteria) this;
        }

        public Criteria andMachineNoGreaterThanOrEqualTo(String value) {
            addCriterion("machine_no >=", value, "machineNo");
            return (Criteria) this;
        }

        public Criteria andMachineNoLessThan(String value) {
            addCriterion("machine_no <", value, "machineNo");
            return (Criteria) this;
        }

        public Criteria andMachineNoLessThanOrEqualTo(String value) {
            addCriterion("machine_no <=", value, "machineNo");
            return (Criteria) this;
        }

        public Criteria andMachineNoLike(String value) {
            addCriterion("machine_no like", value, "machineNo");
            return (Criteria) this;
        }

        public Criteria andMachineNoNotLike(String value) {
            addCriterion("machine_no not like", value, "machineNo");
            return (Criteria) this;
        }

        public Criteria andMachineNoIn(List<String> values) {
            addCriterion("machine_no in", values, "machineNo");
            return (Criteria) this;
        }

        public Criteria andMachineNoNotIn(List<String> values) {
            addCriterion("machine_no not in", values, "machineNo");
            return (Criteria) this;
        }

        public Criteria andMachineNoBetween(String value1, String value2) {
            addCriterion("machine_no between", value1, value2, "machineNo");
            return (Criteria) this;
        }

        public Criteria andMachineNoNotBetween(String value1, String value2) {
            addCriterion("machine_no not between", value1, value2, "machineNo");
            return (Criteria) this;
        }

        public Criteria andPileNoIsNull() {
            addCriterion("pile_no is null");
            return (Criteria) this;
        }

        public Criteria andPileNoIsNotNull() {
            addCriterion("pile_no is not null");
            return (Criteria) this;
        }

        public Criteria andPileNoEqualTo(String value) {
            addCriterion("pile_no =", value, "pileNo");
            return (Criteria) this;
        }

        public Criteria andPileNoNotEqualTo(String value) {
            addCriterion("pile_no <>", value, "pileNo");
            return (Criteria) this;
        }

        public Criteria andPileNoGreaterThan(String value) {
            addCriterion("pile_no >", value, "pileNo");
            return (Criteria) this;
        }

        public Criteria andPileNoGreaterThanOrEqualTo(String value) {
            addCriterion("pile_no >=", value, "pileNo");
            return (Criteria) this;
        }

        public Criteria andPileNoLessThan(String value) {
            addCriterion("pile_no <", value, "pileNo");
            return (Criteria) this;
        }

        public Criteria andPileNoLessThanOrEqualTo(String value) {
            addCriterion("pile_no <=", value, "pileNo");
            return (Criteria) this;
        }

        public Criteria andPileNoLike(String value) {
            addCriterion("pile_no like", value, "pileNo");
            return (Criteria) this;
        }

        public Criteria andPileNoNotLike(String value) {
            addCriterion("pile_no not like", value, "pileNo");
            return (Criteria) this;
        }

        public Criteria andPileNoIn(List<String> values) {
            addCriterion("pile_no in", values, "pileNo");
            return (Criteria) this;
        }

        public Criteria andPileNoNotIn(List<String> values) {
            addCriterion("pile_no not in", values, "pileNo");
            return (Criteria) this;
        }

        public Criteria andPileNoBetween(String value1, String value2) {
            addCriterion("pile_no between", value1, value2, "pileNo");
            return (Criteria) this;
        }

        public Criteria andPileNoNotBetween(String value1, String value2) {
            addCriterion("pile_no not between", value1, value2, "pileNo");
            return (Criteria) this;
        }

        public Criteria andFirstWeightIsNull() {
            addCriterion("first_weight is null");
            return (Criteria) this;
        }

        public Criteria andFirstWeightIsNotNull() {
            addCriterion("first_weight is not null");
            return (Criteria) this;
        }

        public Criteria andFirstWeightEqualTo(Integer value) {
            addCriterion("first_weight =", value, "firstWeight");
            return (Criteria) this;
        }

        public Criteria andFirstWeightNotEqualTo(Integer value) {
            addCriterion("first_weight <>", value, "firstWeight");
            return (Criteria) this;
        }

        public Criteria andFirstWeightGreaterThan(Integer value) {
            addCriterion("first_weight >", value, "firstWeight");
            return (Criteria) this;
        }

        public Criteria andFirstWeightGreaterThanOrEqualTo(Integer value) {
            addCriterion("first_weight >=", value, "firstWeight");
            return (Criteria) this;
        }

        public Criteria andFirstWeightLessThan(Integer value) {
            addCriterion("first_weight <", value, "firstWeight");
            return (Criteria) this;
        }

        public Criteria andFirstWeightLessThanOrEqualTo(Integer value) {
            addCriterion("first_weight <=", value, "firstWeight");
            return (Criteria) this;
        }

        public Criteria andFirstWeightIn(List<Integer> values) {
            addCriterion("first_weight in", values, "firstWeight");
            return (Criteria) this;
        }

        public Criteria andFirstWeightNotIn(List<Integer> values) {
            addCriterion("first_weight not in", values, "firstWeight");
            return (Criteria) this;
        }

        public Criteria andFirstWeightBetween(Integer value1, Integer value2) {
            addCriterion("first_weight between", value1, value2, "firstWeight");
            return (Criteria) this;
        }

        public Criteria andFirstWeightNotBetween(Integer value1, Integer value2) {
            addCriterion("first_weight not between", value1, value2, "firstWeight");
            return (Criteria) this;
        }

        public Criteria andSecondWeightIsNull() {
            addCriterion("second_weight is null");
            return (Criteria) this;
        }

        public Criteria andSecondWeightIsNotNull() {
            addCriterion("second_weight is not null");
            return (Criteria) this;
        }

        public Criteria andSecondWeightEqualTo(Integer value) {
            addCriterion("second_weight =", value, "secondWeight");
            return (Criteria) this;
        }

        public Criteria andSecondWeightNotEqualTo(Integer value) {
            addCriterion("second_weight <>", value, "secondWeight");
            return (Criteria) this;
        }

        public Criteria andSecondWeightGreaterThan(Integer value) {
            addCriterion("second_weight >", value, "secondWeight");
            return (Criteria) this;
        }

        public Criteria andSecondWeightGreaterThanOrEqualTo(Integer value) {
            addCriterion("second_weight >=", value, "secondWeight");
            return (Criteria) this;
        }

        public Criteria andSecondWeightLessThan(Integer value) {
            addCriterion("second_weight <", value, "secondWeight");
            return (Criteria) this;
        }

        public Criteria andSecondWeightLessThanOrEqualTo(Integer value) {
            addCriterion("second_weight <=", value, "secondWeight");
            return (Criteria) this;
        }

        public Criteria andSecondWeightIn(List<Integer> values) {
            addCriterion("second_weight in", values, "secondWeight");
            return (Criteria) this;
        }

        public Criteria andSecondWeightNotIn(List<Integer> values) {
            addCriterion("second_weight not in", values, "secondWeight");
            return (Criteria) this;
        }

        public Criteria andSecondWeightBetween(Integer value1, Integer value2) {
            addCriterion("second_weight between", value1, value2, "secondWeight");
            return (Criteria) this;
        }

        public Criteria andSecondWeightNotBetween(Integer value1, Integer value2) {
            addCriterion("second_weight not between", value1, value2, "secondWeight");
            return (Criteria) this;
        }

        public Criteria andFirstDepthIsNull() {
            addCriterion("first_depth is null");
            return (Criteria) this;
        }

        public Criteria andFirstDepthIsNotNull() {
            addCriterion("first_depth is not null");
            return (Criteria) this;
        }

        public Criteria andFirstDepthEqualTo(Float value) {
            addCriterion("first_depth =", value, "firstDepth");
            return (Criteria) this;
        }

        public Criteria andFirstDepthNotEqualTo(Float value) {
            addCriterion("first_depth <>", value, "firstDepth");
            return (Criteria) this;
        }

        public Criteria andFirstDepthGreaterThan(Float value) {
            addCriterion("first_depth >", value, "firstDepth");
            return (Criteria) this;
        }

        public Criteria andFirstDepthGreaterThanOrEqualTo(Float value) {
            addCriterion("first_depth >=", value, "firstDepth");
            return (Criteria) this;
        }

        public Criteria andFirstDepthLessThan(Float value) {
            addCriterion("first_depth <", value, "firstDepth");
            return (Criteria) this;
        }

        public Criteria andFirstDepthLessThanOrEqualTo(Float value) {
            addCriterion("first_depth <=", value, "firstDepth");
            return (Criteria) this;
        }

        public Criteria andFirstDepthIn(List<Float> values) {
            addCriterion("first_depth in", values, "firstDepth");
            return (Criteria) this;
        }

        public Criteria andFirstDepthNotIn(List<Float> values) {
            addCriterion("first_depth not in", values, "firstDepth");
            return (Criteria) this;
        }

        public Criteria andFirstDepthBetween(Float value1, Float value2) {
            addCriterion("first_depth between", value1, value2, "firstDepth");
            return (Criteria) this;
        }

        public Criteria andFirstDepthNotBetween(Float value1, Float value2) {
            addCriterion("first_depth not between", value1, value2, "firstDepth");
            return (Criteria) this;
        }

        public Criteria andSecondDepthIsNull() {
            addCriterion("second_depth is null");
            return (Criteria) this;
        }

        public Criteria andSecondDepthIsNotNull() {
            addCriterion("second_depth is not null");
            return (Criteria) this;
        }

        public Criteria andSecondDepthEqualTo(Float value) {
            addCriterion("second_depth =", value, "secondDepth");
            return (Criteria) this;
        }

        public Criteria andSecondDepthNotEqualTo(Float value) {
            addCriterion("second_depth <>", value, "secondDepth");
            return (Criteria) this;
        }

        public Criteria andSecondDepthGreaterThan(Float value) {
            addCriterion("second_depth >", value, "secondDepth");
            return (Criteria) this;
        }

        public Criteria andSecondDepthGreaterThanOrEqualTo(Float value) {
            addCriterion("second_depth >=", value, "secondDepth");
            return (Criteria) this;
        }

        public Criteria andSecondDepthLessThan(Float value) {
            addCriterion("second_depth <", value, "secondDepth");
            return (Criteria) this;
        }

        public Criteria andSecondDepthLessThanOrEqualTo(Float value) {
            addCriterion("second_depth <=", value, "secondDepth");
            return (Criteria) this;
        }

        public Criteria andSecondDepthIn(List<Float> values) {
            addCriterion("second_depth in", values, "secondDepth");
            return (Criteria) this;
        }

        public Criteria andSecondDepthNotIn(List<Float> values) {
            addCriterion("second_depth not in", values, "secondDepth");
            return (Criteria) this;
        }

        public Criteria andSecondDepthBetween(Float value1, Float value2) {
            addCriterion("second_depth between", value1, value2, "secondDepth");
            return (Criteria) this;
        }

        public Criteria andSecondDepthNotBetween(Float value1, Float value2) {
            addCriterion("second_depth not between", value1, value2, "secondDepth");
            return (Criteria) this;
        }

        public Criteria andSumDepthIsNull() {
            addCriterion("sum_depth is null");
            return (Criteria) this;
        }

        public Criteria andSumDepthIsNotNull() {
            addCriterion("sum_depth is not null");
            return (Criteria) this;
        }

        public Criteria andSumDepthEqualTo(Float value) {
            addCriterion("sum_depth =", value, "sumDepth");
            return (Criteria) this;
        }

        public Criteria andSumDepthNotEqualTo(Float value) {
            addCriterion("sum_depth <>", value, "sumDepth");
            return (Criteria) this;
        }

        public Criteria andSumDepthGreaterThan(Float value) {
            addCriterion("sum_depth >", value, "sumDepth");
            return (Criteria) this;
        }

        public Criteria andSumDepthGreaterThanOrEqualTo(Float value) {
            addCriterion("sum_depth >=", value, "sumDepth");
            return (Criteria) this;
        }

        public Criteria andSumDepthLessThan(Float value) {
            addCriterion("sum_depth <", value, "sumDepth");
            return (Criteria) this;
        }

        public Criteria andSumDepthLessThanOrEqualTo(Float value) {
            addCriterion("sum_depth <=", value, "sumDepth");
            return (Criteria) this;
        }

        public Criteria andSumDepthIn(List<Float> values) {
            addCriterion("sum_depth in", values, "sumDepth");
            return (Criteria) this;
        }

        public Criteria andSumDepthNotIn(List<Float> values) {
            addCriterion("sum_depth not in", values, "sumDepth");
            return (Criteria) this;
        }

        public Criteria andSumDepthBetween(Float value1, Float value2) {
            addCriterion("sum_depth between", value1, value2, "sumDepth");
            return (Criteria) this;
        }

        public Criteria andSumDepthNotBetween(Float value1, Float value2) {
            addCriterion("sum_depth not between", value1, value2, "sumDepth");
            return (Criteria) this;
        }

        public Criteria andCollectDataIsNull() {
            addCriterion("collect_data is null");
            return (Criteria) this;
        }

        public Criteria andCollectDataIsNotNull() {
            addCriterion("collect_data is not null");
            return (Criteria) this;
        }

        public Criteria andCollectDataEqualTo(String value) {
            addCriterion("collect_data =", value, "collectData");
            return (Criteria) this;
        }

        public Criteria andCollectDataNotEqualTo(String value) {
            addCriterion("collect_data <>", value, "collectData");
            return (Criteria) this;
        }

        public Criteria andCollectDataGreaterThan(String value) {
            addCriterion("collect_data >", value, "collectData");
            return (Criteria) this;
        }

        public Criteria andCollectDataGreaterThanOrEqualTo(String value) {
            addCriterion("collect_data >=", value, "collectData");
            return (Criteria) this;
        }

        public Criteria andCollectDataLessThan(String value) {
            addCriterion("collect_data <", value, "collectData");
            return (Criteria) this;
        }

        public Criteria andCollectDataLessThanOrEqualTo(String value) {
            addCriterion("collect_data <=", value, "collectData");
            return (Criteria) this;
        }

        public Criteria andCollectDataLike(String value) {
            addCriterion("collect_data like", value, "collectData");
            return (Criteria) this;
        }

        public Criteria andCollectDataNotLike(String value) {
            addCriterion("collect_data not like", value, "collectData");
            return (Criteria) this;
        }

        public Criteria andCollectDataIn(List<String> values) {
            addCriterion("collect_data in", values, "collectData");
            return (Criteria) this;
        }

        public Criteria andCollectDataNotIn(List<String> values) {
            addCriterion("collect_data not in", values, "collectData");
            return (Criteria) this;
        }

        public Criteria andCollectDataBetween(String value1, String value2) {
            addCriterion("collect_data between", value1, value2, "collectData");
            return (Criteria) this;
        }

        public Criteria andCollectDataNotBetween(String value1, String value2) {
            addCriterion("collect_data not between", value1, value2, "collectData");
            return (Criteria) this;
        }

        public Criteria andGatherTimeIsNull() {
            addCriterion("gather_time is null");
            return (Criteria) this;
        }

        public Criteria andGatherTimeIsNotNull() {
            addCriterion("gather_time is not null");
            return (Criteria) this;
        }

        public Criteria andGatherTimeEqualTo(Date value) {
            addCriterion("gather_time =", value, "gatherTime");
            return (Criteria) this;
        }

        public Criteria andGatherTimeNotEqualTo(Date value) {
            addCriterion("gather_time <>", value, "gatherTime");
            return (Criteria) this;
        }

        public Criteria andGatherTimeGreaterThan(Date value) {
            addCriterion("gather_time >", value, "gatherTime");
            return (Criteria) this;
        }

        public Criteria andGatherTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("gather_time >=", value, "gatherTime");
            return (Criteria) this;
        }

        public Criteria andGatherTimeLessThan(Date value) {
            addCriterion("gather_time <", value, "gatherTime");
            return (Criteria) this;
        }

        public Criteria andGatherTimeLessThanOrEqualTo(Date value) {
            addCriterion("gather_time <=", value, "gatherTime");
            return (Criteria) this;
        }

        public Criteria andGatherTimeIn(List<Date> values) {
            addCriterion("gather_time in", values, "gatherTime");
            return (Criteria) this;
        }

        public Criteria andGatherTimeNotIn(List<Date> values) {
            addCriterion("gather_time not in", values, "gatherTime");
            return (Criteria) this;
        }

        public Criteria andGatherTimeBetween(Date value1, Date value2) {
            addCriterion("gather_time between", value1, value2, "gatherTime");
            return (Criteria) this;
        }

        public Criteria andGatherTimeNotBetween(Date value1, Date value2) {
            addCriterion("gather_time not between", value1, value2, "gatherTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeIsNull() {
            addCriterion("begin_time is null");
            return (Criteria) this;
        }

        public Criteria andBeginTimeIsNotNull() {
            addCriterion("begin_time is not null");
            return (Criteria) this;
        }

        public Criteria andBeginTimeEqualTo(Date value) {
            addCriterion("begin_time =", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeNotEqualTo(Date value) {
            addCriterion("begin_time <>", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeGreaterThan(Date value) {
            addCriterion("begin_time >", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("begin_time >=", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeLessThan(Date value) {
            addCriterion("begin_time <", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeLessThanOrEqualTo(Date value) {
            addCriterion("begin_time <=", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeIn(List<Date> values) {
            addCriterion("begin_time in", values, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeNotIn(List<Date> values) {
            addCriterion("begin_time not in", values, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeBetween(Date value1, Date value2) {
            addCriterion("begin_time between", value1, value2, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeNotBetween(Date value1, Date value2) {
            addCriterion("begin_time not between", value1, value2, "beginTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNull() {
            addCriterion("end_time is null");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNotNull() {
            addCriterion("end_time is not null");
            return (Criteria) this;
        }

        public Criteria andEndTimeEqualTo(Date value) {
            addCriterion("end_time =", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotEqualTo(Date value) {
            addCriterion("end_time <>", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThan(Date value) {
            addCriterion("end_time >", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("end_time >=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThan(Date value) {
            addCriterion("end_time <", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("end_time <=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIn(List<Date> values) {
            addCriterion("end_time in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotIn(List<Date> values) {
            addCriterion("end_time not in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeBetween(Date value1, Date value2) {
            addCriterion("end_time between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("end_time not between", value1, value2, "endTime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}