package com.wildcodeschool.sea8.kurzs22.spring02onTheRoad;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.ResponseStatusException;

@Controller
public class DoctorController {

    final static String[][] DOCTORS = {
                        { "actor", "incarnation", "series", "episodes", "start", "startAge", "end", "endAge" },
                        { "William Hartnell", "First Doctor", "4", "134 (29 stories)", "23 November 1963", "55", "29 October 1966", "58" },
                        { "Patrick Troughton", "Second Doctor", "3", "119 (21 stories)", "5 November 1966", "46", "21 June 1969", "49" },
                        { "Jon Pertwee", "Third Doctor", "5", "128 (24 stories)", "3 January 1970", "50", "8 June 1974", "54" },
                        { "Tom Baker", "Fourth Doctor", "7", "172 (41 stories)", "28 December 1974", "40", "21 March 1981", "47" },
                        { "Peter Davison", "Fifth Doctor", "3", "69 (20 stories)", "4 January 1982", "30", "16 March 1984", "32" },
                        { "Colin Baker", "Sixth Doctor", "3", "31 (8 stories)", "22 March 1984", "40", "6 December 1986", "43" },
                        { "Sylvester McCoy", "Seventh Doctor", "3", "42 (12 stories)", "7 September 1987", "44", "6 December 1989", "46" },
                        { "Paul McGann", "Eighth Doctor", "—", "1 (1 story)", "27 May 1996", "36", "27 May 1996[note 6]", "36" },
                        { "Christopher Eccleston", "Ninth Doctor", "1", "13 (10 stories)", "26 March 2005", "41", "18 June 2005", "41" },
                        { "David Tennant", "Tenth Doctor", "3", "47 (36 stories)", "25 December 2005", "34", "1 January 2010", "38" },
                        { "Matt Smith", "Eleventh Doctor", "3", "44 (39 stories)", "3 April 2010", "27", "25 December 2013", "31" },
                        { "Peter Capaldi", "Twelfth Doctor", "3", "40 (35 stories)", "23 August 2014", "55", "25 December 2017", "59" },
                        { "Jodie Whittaker", "Thirteenth Doctor", "3", "29 (22 stories)", "7 October 2018", "36", "-", "-" }
    };

    @RequestMapping("/doctor/{id}")
    @ResponseBody
    String getDoctor(@PathVariable int id) {
        if (id <= 0 || id > 13) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Impossible to retrieve the incarnation " + id); // 404 http error
        }
        if (id <= 8) {
            throw new ResponseStatusException(HttpStatus.SEE_OTHER, "Doctor not accessible"); // 303 http error
        }
        String actor = "{ ";
        int numFields = DoctorController.DOCTORS[0].length;
        for (int i = 0; i < numFields ; i++) {
            actor += "\"" + DoctorController.DOCTORS[0][i] + "\": \"" + DoctorController.DOCTORS[id][i] + "\"";
            if (i < numFields - 1) actor += ", ";
            else actor += " }";
        }
        return actor;
    }
}
