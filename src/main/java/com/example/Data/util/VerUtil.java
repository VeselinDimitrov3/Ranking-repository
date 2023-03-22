package com.example.Data.util;


import com.example.Data.entity.Clubs;
import com.example.Data.entity.NationalTeams;
import com.example.Data.exception.ClubDoublingException;
import com.example.Data.exception.NationalTeamDoublingException;

import java.util.List;

public final class VerUtil {

    public static boolean isClubSaveOk(List<Clubs> clubs, String FC) throws ClubDoublingException {
        if (isFCUnique(clubs, FC)) {
                return true;
            } else {
                throw new ClubDoublingException("Existing football club!");
            }
        }
            public static boolean isFCUnique(List<Clubs> clubs, String FC) {
                for (Clubs club : clubs) {
                    if (club.getFC().equalsIgnoreCase(FC)) {
                        return false;
                    }
                }
                return true;
            }

    public static boolean isNationalTeamSaveOk(List<NationalTeams> nationalTeams, String FC) throws NationalTeamDoublingException {
        if (isTeamUnique(nationalTeams, FC)) {
            return true;
        } else {
            throw new NationalTeamDoublingException("Existing national team!");
        }
    }

    public static boolean isTeamUnique(List<NationalTeams> nationalTeams, String team) {
        for (NationalTeams nation : nationalTeams) {
            if (nation.getTeam().equalsIgnoreCase(team)) {
                return false;
            }
        }
        return true;
    }


}

