/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author minha
 */
public class VoteUser {

    private String idVote, voteByVote;

    public VoteUser(String idVote, String voteByVote) {
        this.idVote = idVote;
        this.voteByVote = voteByVote;
    }

    public String getIdVote() {
        return idVote;
    }

    public void setIdVote(String idVote) {
        this.idVote = idVote;
    }

    public String getVoteByVote() {
        return voteByVote;
    }

    public void setVoteByVote(String voteByVote) {
        this.voteByVote = voteByVote;
    }

}
