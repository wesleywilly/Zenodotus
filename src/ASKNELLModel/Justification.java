/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ASKNELLModel;

import org.json.simple.JSONObject;

/**
 *
 * @author WesleyW
 */
public class Justification {
    private static final String SCORE = "score";
    private static final String AGENT = "agent";
    private static final String AGENT_TYPE= "agentType";
    private static final String DATE = "date";        
    private static final String ITERATION = "iteration";        
    private static final String COMMENT = "comment";        
    private static final String UPDATE_ITERATION = "updateIteration";
    
    private double score;
    private String agent;
    private String agentType;
    private String date;
    private long iteration;
    private String comment;
    private long updateIteration;

    public Justification(JSONObject jJustification){
        score = (double) jJustification.get(SCORE);
        agent = (String) jJustification.get(AGENT);
        agentType = (String) jJustification.get(AGENT_TYPE);
        date = (String) jJustification.get(DATE);
        iteration = (long) jJustification.get(ITERATION);
        comment = (String) jJustification.get(COMMENT);
        updateIteration = (long) jJustification.get(UPDATE_ITERATION);
    }
    
    public JSONObject toJSON(){
        JSONObject jJustification = new JSONObject();
        jJustification.put(SCORE, score);
        jJustification.put(AGENT, agent);
        jJustification.put(AGENT_TYPE, agentType);
        jJustification.put(DATE, date);
        jJustification.put(ITERATION, iteration);
        jJustification.put(COMMENT, comment);
        jJustification.put(UPDATE_ITERATION, updateIteration);
        
        return jJustification;
    }
    
    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getAgent() {
        return agent;
    }

    public void setAgent(String agent) {
        this.agent = agent;
    }

    public String getAgentType() {
        return agentType;
    }

    public void setAgentType(String agentType) {
        this.agentType = agentType;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public long getIteration() {
        return iteration;
    }

    public void setIteration(long iteration) {
        this.iteration = iteration;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public long getUpdateIteration() {
        return updateIteration;
    }

    public void setUpdateIteration(long updateIteration) {
        this.updateIteration = updateIteration;
    }
    
    
    
}
