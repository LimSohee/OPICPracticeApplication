package com.sh.opicpracticeapplication.exam;

public enum EXAM_QUESTION_BANK {
    INTRO_INTRO(SUBJECT.INTRO, TYPE.INTRO, ""),

    MOVIE_RECENT(SUBJECT.MOVIE, TYPE.RECENT, ""),
    MOVIE_BEFORE_AFTER(SUBJECT.MOVIE, TYPE.BEFORE_AFTER, "What do you normally do before watching the movie? What do you do after? Please tell me about your typical day when you go to the movies."),
    MOVIE_FIRST_TIME(SUBJECT.MOVIE, TYPE.FIRST_TIME, "When was the first time that you watched a movie at the movie theater? What is your memory about that time? How has your movie taste changed since then?"),
    MOVIE_PAST_TODAY(SUBJECT.MOVIE, TYPE.PAST_TODAY, ""),
    MOVIE_MEMORABLE(SUBJECT.MOVIE, TYPE.MEMORABLE, "Can you describe a memory you have about a movie or a movie theater? Maybe you visited a theater that was very nice. Or maybe you saw a movie that was particularly interesting. Give me a detailed description about everything you remember."),
    MOVIE_PLACE(SUBJECT.MOVIE, TYPE.PLACE, "You indicated that you go to the movies in your free time. Where do you usually go to see a movie? Describe the movie theater you often go to."),
    MOVIE_ACTIVITY(SUBJECT.MOVIE, TYPE.ACTIVITY, ""),
    MOVIE_PERSON(SUBJECT.MOVIE, TYPE.PERSON, "Tell me about your favorite movie actor or actress. Why do you like him or her? What kinds of movies has he or she been in?"),
    MOVIE_OBJECT(SUBJECT.MOVIE, TYPE.OBJECT, ""),
    MOVIE_W5H1(SUBJECT.MOVIE, TYPE.W5H1, "You indicated that you go to the movies. Tell me about the kind of movies that you like to go see."),
    MOVIE_ACT_OUT(SUBJECT.MOVIE, TYPE.ACT_OUT, ""),
    MOVIE_ALTERNATIVE(SUBJECT.MOVIE, TYPE.ALTERNATIVE, ""),
    MOVIE_HAPPEN(SUBJECT.MOVIE, TYPE.HAPPEN, ""),
    MOVIE_ASK_ME(SUBJECT.MOVIE, TYPE.ASK_ME, ""),

    PERFORMANCE_RECENT(SUBJECT.PERFORMANCE, TYPE.RECENT, ""),
    PERFORMANCE_BEFORE_AFTER(SUBJECT.PERFORMANCE, TYPE.BEFORE_AFTER, "What do you typically do when going to see a movie? Discuss what you do before and after going to the performance. Who do you typically go to movies with."),
    PERFORMANCE_FIRST_TIME(SUBJECT.PERFORMANCE, TYPE.FIRST_TIME, ""),
    PERFORMANCE_PAST_TODAY(SUBJECT.PERFORMANCE, TYPE.PAST_TODAY, ""),
    PERFORMANCE_MEMORABLE(SUBJECT.PERFORMANCE, TYPE.MEMORABLE, ""),
    PERFORMANCE_PLACE(SUBJECT.PERFORMANCE, TYPE.PLACE, ""),
    PERFORMANCE_ACTIVITY(SUBJECT.PERFORMANCE, TYPE.ACTIVITY, ""),
    PERFORMANCE_PERSON(SUBJECT.PERFORMANCE, TYPE.PERSON, ""),
    PERFORMANCE_OBJECT(SUBJECT.PERFORMANCE, TYPE.OBJECT, ""),
    PERFORMANCE_W5H1(SUBJECT.PERFORMANCE, TYPE.W5H1, ""),
    PERFORMANCE_ACT_OUT(SUBJECT.PERFORMANCE, TYPE.ACT_OUT, ""),
    PERFORMANCE_ALTERNATIVE(SUBJECT.PERFORMANCE, TYPE.ALTERNATIVE, "I'm sorry, but there is a problem I need you to resolve. You find out that the performance you want to go during your vacation is sold out. Call a friend and tell him about the situation, and provide some alternatives."),
    PERFORMANCE_HAPPEN(SUBJECT.PERFORMANCE, TYPE.HAPPEN, ""),
    PERFORMANCE_ASK_ME(SUBJECT.PERFORMANCE, TYPE.ASK_ME, ""),

    CONCERT_RECENT(SUBJECT.CONCERT, TYPE.RECENT, "Tell me about a recent concert you went to. When was it? Where did it take place? Who played at the concert? How did you like it? And who did you go with?"),
    CONCERT_BEFORE_AFTER(SUBJECT.CONCERT, TYPE.BEFORE_AFTER, "Now, tell me the typical day when you go to the concert. Tell me everything you do from beginning to the end."),
    CONCERT_FIRST_TIME(SUBJECT.CONCERT, TYPE.FIRST_TIME, ""),
    CONCERT_PAST_TODAY(SUBJECT.CONCERT, TYPE.PAST_TODAY, ""),
    CONCERT_MEMORABLE(SUBJECT.CONCERT, TYPE.MEMORABLE, "I'd like to know about one of your memorable experiences at a concert. Tell me what exactly happened. Why was the concert so memorable? Tell me about the experience with a lot of detail."),
    CONCERT_PLACE(SUBJECT.CONCERT, TYPE.PLACE, ""),
    CONCERT_ACTIVITY(SUBJECT.CONCERT, TYPE.ACTIVITY, ""),
    CONCERT_PERSON(SUBJECT.CONCERT, TYPE.PERSON, ""),
    CONCERT_OBJECT(SUBJECT.CONCERT, TYPE.OBJECT, ""),
    CONCERT_W5H1(SUBJECT.CONCERT, TYPE.W5H1, ""),
    CONCERT_ACT_OUT(SUBJECT.CONCERT, TYPE.ACT_OUT, ""),
    CONCERT_ALTERNATIVE(SUBJECT.CONCERT, TYPE.ALTERNATIVE, ""),
    CONCERT_HAPPEN(SUBJECT.CONCERT, TYPE.HAPPEN, ""),
    CONCERT_ASK_ME(SUBJECT.CONCERT, TYPE.ASK_ME, ""),

    PARK_RECENT(SUBJECT.PARK, TYPE.RECENT, ""),
    PARK_BEFORE_AFTER(SUBJECT.PARK, TYPE.BEFORE_AFTER, ""),
    PARK_FIRST_TIME(SUBJECT.PARK, TYPE.FIRST_TIME, ""),
    PARK_PAST_TODAY(SUBJECT.PARK, TYPE.PAST_TODAY, ""),
    PARK_MEMORABLE(SUBJECT.PARK, TYPE.MEMORABLE, "Tell me about a memorable or interesting event that happened in a park. What exactly happened? Why was it so memorable to you? Please tell me all about it in as much detail as possible."),
    PARK_PLACE(SUBJECT.PARK, TYPE.PLACE, "You indicated in the survey that you like to go to parks. Pick one of the parks you often visit and tell me where it is located and what it looks like."),
    PARK_ACTIVITY(SUBJECT.PARK, TYPE.ACTIVITY, "Can you tell me about the people you see at the park that you often go to? What kind of people are there? And what do they usually do there? Are there many children or old people?"),
    PARK_PERSON(SUBJECT.PARK, TYPE.PERSON, "Can you tell me about the people you see at the park that you often go to? What kind of people are there? And what do they usually do there? Are there many children or old people?"),
    PARK_OBJECT(SUBJECT.PARK, TYPE.OBJECT, ""),
    PARK_W5H1(SUBJECT.PARK, TYPE.W5H1, "Can you describe one of the parks you often go to? Where is it located? What does it look like? What can you see in the park? Why do you often go there? Please give me a full description."),
    PARK_ACT_OUT(SUBJECT.PARK, TYPE.ACT_OUT, ""),
    PARK_ALTERNATIVE(SUBJECT.PARK, TYPE.ALTERNATIVE, ""),
    PARK_HAPPEN(SUBJECT.PARK, TYPE.HAPPEN, ""),
    PARK_ASK_ME(SUBJECT.PARK, TYPE.ASK_ME, ""),

    BEACH_RECENT(SUBJECT.BEACH, TYPE.RECENT, ""),
    BEACH_BEFORE_AFTER(SUBJECT.BEACH, TYPE.BEFORE_AFTER, ""),
    BEACH_FIRST_TIME(SUBJECT.BEACH, TYPE.FIRST_TIME, ""),
    BEACH_PAST_TODAY(SUBJECT.BEACH, TYPE.PAST_TODAY, ""),
    BEACH_MEMORABLE(SUBJECT.BEACH, TYPE.MEMORABLE, ""),
    BEACH_PLACE(SUBJECT.BEACH, TYPE.PLACE, ""),
    BEACH_ACTIVITY(SUBJECT.BEACH, TYPE.ACTIVITY, ""),
    BEACH_PERSON(SUBJECT.BEACH, TYPE.PERSON, ""),
    BEACH_OBJECT(SUBJECT.BEACH, TYPE.OBJECT, ""),
    BEACH_W5H1(SUBJECT.BEACH, TYPE.W5H1, ""),
    BEACH_ACT_OUT(SUBJECT.BEACH, TYPE.ACT_OUT, ""),
    BEACH_ALTERNATIVE(SUBJECT.BEACH, TYPE.ALTERNATIVE, ""),
    BEACH_HAPPEN(SUBJECT.BEACH, TYPE.HAPPEN, ""),
    BEACH_ASK_ME(SUBJECT.BEACH, TYPE.ASK_ME, ""),

    SHOPPING_RECENT(SUBJECT.SHOPPING, TYPE.RECENT, "Tell me about a recent grocery shopping trip. Where did you go shopping? When did you go shopping? Who did you go with? What did you buy? Did anything funny or exciting happen while you were shopping? Please give me a full description."),
    SHOPPING_BEFORE_AFTER(SUBJECT.SHOPPING, TYPE.BEFORE_AFTER, ""),
    SHOPPING_FIRST_TIME(SUBJECT.SHOPPING, TYPE.FIRST_TIME, "Tell me about how you first became interested in shopping. Where do you often go for shopping? Who did you start enjoying shopping with?"),
    SHOPPING_PAST_TODAY(SUBJECT.SHOPPING, TYPE.PAST_TODAY, "I'd like you to explain recent changes in shopping trends. Is it different from past trends? If so, what has changed? It seems like people might be shopping for various reasons, not just for buying products. I'd like to know about it in as much detail as possible."),
    SHOPPING_MEMORABLE(SUBJECT.SHOPPING, TYPE.MEMORABLE, "Do you have a special shopping experience? What were you shopping for? When was it? Who were you with? Tell me about the experience."),
    SHOPPING_PLACE(SUBJECT.SHOPPING, TYPE.PLACE, ""),
    SHOPPING_ACTIVITY(SUBJECT.SHOPPING, TYPE.ACTIVITY, ""),
    SHOPPING_PERSON(SUBJECT.SHOPPING, TYPE.PERSON, ""),
    SHOPPING_OBJECT(SUBJECT.SHOPPING, TYPE.OBJECT, ""),
    SHOPPING_W5H1(SUBJECT.SHOPPING, TYPE.W5H1, ""),
    SHOPPING_ACT_OUT(SUBJECT.SHOPPING, TYPE.ACT_OUT, ""),
    SHOPPING_ALTERNATIVE(SUBJECT.SHOPPING, TYPE.ALTERNATIVE, ""),
    SHOPPING_HAPPEN(SUBJECT.SHOPPING, TYPE.HAPPEN, ""),
    SHOPPING_ASK_ME(SUBJECT.SHOPPING, TYPE.ASK_ME, ""),

    MUSIC_RECENT(SUBJECT.MUSIC, TYPE.RECENT, ""),
    MUSIC_BEFORE_AFTER(SUBJECT.MUSIC, TYPE.BEFORE_AFTER, ""),
    MUSIC_FIRST_TIME(SUBJECT.MUSIC, TYPE.FIRST_TIME, "When did you first become interested in music? Did anyone influence your music preference? Do you still listen to the same kind of music you did when you were a child? If not, how have your preferences changed?"),
    MUSIC_PAST_TODAY(SUBJECT.MUSIC, TYPE.PAST_TODAY, ""),
    MUSIC_MEMORABLE(SUBJECT.MUSIC, TYPE.MEMORABLE, ""),
    MUSIC_PLACE(SUBJECT.MUSIC, TYPE.PLACE, ""),
    MUSIC_ACTIVITY(SUBJECT.MUSIC, TYPE.ACTIVITY, ""),
    MUSIC_PERSON(SUBJECT.MUSIC, TYPE.PERSON, "Who is your favorite singer or composer? Why do you like that singer? Tell me about your favorite singer in as much detail as possible."),
    MUSIC_OBJECT(SUBJECT.MUSIC, TYPE.OBJECT, ""),
    MUSIC_W5H1(SUBJECT.MUSIC, TYPE.W5H1, "You indicated in the survey that you enjoy listening to music. How often do you listen to music? When and where do you usually listen to music? And what kind of music do you usually listen to? Whose song is it?"),
    MUSIC_ACT_OUT(SUBJECT.MUSIC, TYPE.ACT_OUT, ""),
    MUSIC_ALTERNATIVE(SUBJECT.MUSIC, TYPE.ALTERNATIVE, ""),
    MUSIC_HAPPEN(SUBJECT.MUSIC, TYPE.HAPPEN, ""),
    MUSIC_ASK_ME(SUBJECT.MUSIC, TYPE.ASK_ME, ""),

    SWIMMING_RECENT(SUBJECT.SWIMMING, TYPE.RECENT, ""),
    SWIMMING_BEFORE_AFTER(SUBJECT.SWIMMING, TYPE.BEFORE_AFTER, ""),
    SWIMMING_FIRST_TIME(SUBJECT.SWIMMING, TYPE.FIRST_TIME, ""),
    SWIMMING_PAST_TODAY(SUBJECT.SWIMMING, TYPE.PAST_TODAY, ""),
    SWIMMING_MEMORABLE(SUBJECT.SWIMMING, TYPE.MEMORABLE, "Do you have any interesting experience while swimming? If so, please give me a detailed description of the experience."),
    SWIMMING_PLACE(SUBJECT.SWIMMING, TYPE.PLACE, ""),
    SWIMMING_ACTIVITY(SUBJECT.SWIMMING, TYPE.ACTIVITY, ""),
    SWIMMING_PERSON(SUBJECT.SWIMMING, TYPE.PERSON, ""),
    SWIMMING_OBJECT(SUBJECT.SWIMMING, TYPE.OBJECT, ""),
    SWIMMING_W5H1(SUBJECT.SWIMMING, TYPE.W5H1, "You indicated in the survey that you go swimming. How long have you been swimming? How often do you swim? When do you usually swim? Do you normally swim alone?"),
    SWIMMING_ACT_OUT(SUBJECT.SWIMMING, TYPE.ACT_OUT, ""),
    SWIMMING_ALTERNATIVE(SUBJECT.SWIMMING, TYPE.ALTERNATIVE, ""),
    SWIMMING_HAPPEN(SUBJECT.SWIMMING, TYPE.HAPPEN, ""),
    SWIMMING_ASK_ME(SUBJECT.SWIMMING, TYPE.ASK_ME, ""),

    BICYCLE_RECENT(SUBJECT.BICYCLE, TYPE.RECENT, ""),
    BICYCLE_BEFORE_AFTER(SUBJECT.BICYCLE, TYPE.BEFORE_AFTER, ""),
    BICYCLE_FIRST_TIME(SUBJECT.BICYCLE, TYPE.FIRST_TIME, ""),
    BICYCLE_PAST_TODAY(SUBJECT.BICYCLE, TYPE.PAST_TODAY, ""),
    BICYCLE_MEMORABLE(SUBJECT.BICYCLE, TYPE.MEMORABLE, ""),
    BICYCLE_PLACE(SUBJECT.BICYCLE, TYPE.PLACE, ""),
    BICYCLE_ACTIVITY(SUBJECT.BICYCLE, TYPE.ACTIVITY, ""),
    BICYCLE_PERSON(SUBJECT.BICYCLE, TYPE.PERSON, ""),
    BICYCLE_OBJECT(SUBJECT.BICYCLE, TYPE.OBJECT, "You mentioned in the survey that you go out for bike rides. Tell me about your bike. What type of bike is it? Describe your bicycle."),
    BICYCLE_W5H1(SUBJECT.BICYCLE, TYPE.W5H1, ""),
    BICYCLE_ACT_OUT(SUBJECT.BICYCLE, TYPE.ACT_OUT, ""),
    BICYCLE_ALTERNATIVE(SUBJECT.BICYCLE, TYPE.ALTERNATIVE, ""),
    BICYCLE_HAPPEN(SUBJECT.BICYCLE, TYPE.HAPPEN, ""),
    BICYCLE_ASK_ME(SUBJECT.BICYCLE, TYPE.ASK_ME, ""),

    JOGGING_RECENT(SUBJECT.JOGGING, TYPE.RECENT, ""),
    JOGGING_BEFORE_AFTER(SUBJECT.JOGGING, TYPE.BEFORE_AFTER, ""),
    JOGGING_FIRST_TIME(SUBJECT.JOGGING, TYPE.FIRST_TIME, "How did you first become interested in jogging? Who taught you how to jog? What do you like about jogging?"),
    JOGGING_PAST_TODAY(SUBJECT.JOGGING, TYPE.PAST_TODAY, ""),
    JOGGING_MEMORABLE(SUBJECT.JOGGING, TYPE.MEMORABLE, ""),
    JOGGING_PLACE(SUBJECT.JOGGING, TYPE.PLACE, "You responded that you like to jog. I'd like to know your favorite place for jogging. Why do you like the place? What can you see there?"),
    JOGGING_ACTIVITY(SUBJECT.JOGGING, TYPE.ACTIVITY, ""),
    JOGGING_PERSON(SUBJECT.JOGGING, TYPE.PERSON, ""),
    JOGGING_OBJECT(SUBJECT.JOGGING, TYPE.OBJECT, ""),
    JOGGING_W5H1(SUBJECT.JOGGING, TYPE.W5H1, ""),
    JOGGING_ACT_OUT(SUBJECT.JOGGING, TYPE.ACT_OUT, ""),
    JOGGING_ALTERNATIVE(SUBJECT.JOGGING, TYPE.ALTERNATIVE, ""),
    JOGGING_HAPPEN(SUBJECT.JOGGING, TYPE.HAPPEN, ""),
    JOGGING_ASK_ME(SUBJECT.JOGGING, TYPE.ASK_ME, ""),

    WALKING_RECENT(SUBJECT.WALKING, TYPE.RECENT, ""),
    WALKING_BEFORE_AFTER(SUBJECT.WALKING, TYPE.BEFORE_AFTER, ""),
    WALKING_FIRST_TIME(SUBJECT.WALKING, TYPE.FIRST_TIME, ""),
    WALKING_PAST_TODAY(SUBJECT.WALKING, TYPE.PAST_TODAY, ""),
    WALKING_MEMORABLE(SUBJECT.WALKING, TYPE.MEMORABLE, ""),
    WALKING_PLACE(SUBJECT.WALKING, TYPE.PLACE, ""),
    WALKING_ACTIVITY(SUBJECT.WALKING, TYPE.ACTIVITY, ""),
    WALKING_PERSON(SUBJECT.WALKING, TYPE.PERSON, ""),
    WALKING_OBJECT(SUBJECT.WALKING, TYPE.OBJECT, ""),
    WALKING_W5H1(SUBJECT.WALKING, TYPE.W5H1, ""),
    WALKING_ACT_OUT(SUBJECT.WALKING, TYPE.ACT_OUT, ""),
    WALKING_ALTERNATIVE(SUBJECT.WALKING, TYPE.ALTERNATIVE, ""),
    WALKING_HAPPEN(SUBJECT.WALKING, TYPE.HAPPEN, ""),
    WALKING_ASK_ME(SUBJECT.WALKING, TYPE.ASK_ME, ""),

    HOME_VACATION_RECENT(SUBJECT.HOME_VACATION, TYPE.RECENT, "Can you describe your recent vacations at home? How did you spend your vacation? Who did you spend time with? And what did you do with them? Tell me about it in detail."),
    HOME_VACATION_BEFORE_AFTER(SUBJECT.HOME_VACATION, TYPE.BEFORE_AFTER, ""),
    HOME_VACATION_FIRST_TIME(SUBJECT.HOME_VACATION, TYPE.FIRST_TIME, ""),
    HOME_VACATION_PAST_TODAY(SUBJECT.HOME_VACATION, TYPE.PAST_TODAY, ""),
    HOME_VACATION_MEMORABLE(SUBJECT.HOME_VACATION, TYPE.MEMORABLE, ""),
    HOME_VACATION_PLACE(SUBJECT.HOME_VACATION, TYPE.PLACE, ""),
    HOME_VACATION_ACTIVITY(SUBJECT.HOME_VACATION, TYPE.ACTIVITY, ""),
    HOME_VACATION_PERSON(SUBJECT.HOME_VACATION, TYPE.PERSON, ""),
    HOME_VACATION_OBJECT(SUBJECT.HOME_VACATION, TYPE.OBJECT, ""),
    HOME_VACATION_W5H1(SUBJECT.HOME_VACATION, TYPE.W5H1, ""),
    HOME_VACATION_ACT_OUT(SUBJECT.HOME_VACATION, TYPE.ACT_OUT, ""),
    HOME_VACATION_ALTERNATIVE(SUBJECT.HOME_VACATION, TYPE.ALTERNATIVE, ""),
    HOME_VACATION_HAPPEN(SUBJECT.HOME_VACATION, TYPE.HAPPEN, ""),
    HOME_VACATION_ASK_ME(SUBJECT.HOME_VACATION, TYPE.ASK_ME, ""),

    HOME_RECENT(SUBJECT.HOME, TYPE.RECENT, ""),
    HOME_BEFORE_AFTER(SUBJECT.HOME, TYPE.BEFORE_AFTER, ""),
    HOME_FIRST_TIME(SUBJECT.HOME, TYPE.FIRST_TIME, ""),
    HOME_PAST_TODAY(SUBJECT.HOME, TYPE.PAST_TODAY, ""),
    HOME_MEMORABLE(SUBJECT.HOME, TYPE.MEMORABLE, "Tell me about a memorable experience you had at home. Why was it so memorable for you? Tell me about your experience with a lot of details.\""),
    HOME_PLACE(SUBJECT.HOME, TYPE.PLACE, ""),
    HOME_ACTIVITY(SUBJECT.HOME, TYPE.ACTIVITY, "Tell me about the activities you enjoy with your family at home. what kind of things do you do at home with your family? Why do you like it?"),
    HOME_PERSON(SUBJECT.HOME, TYPE.PERSON, ""),
    HOME_OBJECT(SUBJECT.HOME, TYPE.OBJECT, "I'd like to now talk about where you live. Do you live in an apartment or a house? Tell me everything about your home. Give me a description with a lot of details."),
    HOME_W5H1(SUBJECT.HOME, TYPE.W5H1, ""),
    HOME_ACT_OUT(SUBJECT.HOME, TYPE.ACT_OUT, ""),
    HOME_ALTERNATIVE(SUBJECT.HOME, TYPE.ALTERNATIVE, ""),
    HOME_HAPPEN(SUBJECT.HOME, TYPE.HAPPEN, ""),
    HOME_ASK_ME(SUBJECT.HOME, TYPE.ASK_ME, ""),

    HOUSEHOLD_RECENT(SUBJECT.HOUSEHOLD, TYPE.RECENT, "When was the last time you did any household chores? What steps did you take during your chores? How did your house change?"),
    HOUSEHOLD_BEFORE_AFTER(SUBJECT.HOUSEHOLD, TYPE.BEFORE_AFTER, "Tell me about how you get your responsibilities done on your typical day. What are your responsibilities? What steps do you normally take to get them done?"),
    HOUSEHOLD_FIRST_TIME(SUBJECT.HOUSEHOLD, TYPE.FIRST_TIME, "I'd like to know what you did at home in your childhood. What were your responsibilities at home? How often did you do it?"),
    HOUSEHOLD_PAST_TODAY(SUBJECT.HOUSEHOLD, TYPE.PAST_TODAY, ""),
    HOUSEHOLD_MEMORABLE(SUBJECT.HOUSEHOLD, TYPE.MEMORABLE, ""),
    HOUSEHOLD_PLACE(SUBJECT.HOUSEHOLD, TYPE.PLACE, ""),
    HOUSEHOLD_ACTIVITY(SUBJECT.HOUSEHOLD, TYPE.ACTIVITY, ""),
    HOUSEHOLD_PERSON(SUBJECT.HOUSEHOLD, TYPE.PERSON, ""),
    HOUSEHOLD_OBJECT(SUBJECT.HOUSEHOLD, TYPE.OBJECT, ""),
    HOUSEHOLD_W5H1(SUBJECT.HOUSEHOLD, TYPE.W5H1, "Tell me about some household chores you do at home. Do you do the dishes or do the laundry? What else?"),
    HOUSEHOLD_ACT_OUT(SUBJECT.HOUSEHOLD, TYPE.ACT_OUT, ""),
    HOUSEHOLD_ALTERNATIVE(SUBJECT.HOUSEHOLD, TYPE.ALTERNATIVE, ""),
    HOUSEHOLD_HAPPEN(SUBJECT.HOUSEHOLD, TYPE.HAPPEN, ""),
    HOUSEHOLD_ASK_ME(SUBJECT.HOUSEHOLD, TYPE.ASK_ME, ""),

    HOME_IMPROVEMENT_RECENT(SUBJECT.HOME_IMPROVEMENT, TYPE.RECENT, "Tell me about the last time that you enjoyed home improvement project. Tell me the process from beginning to the end."),
    HOME_IMPROVEMENT_BEFORE_AFTER(SUBJECT.HOME_IMPROVEMENT, TYPE.BEFORE_AFTER, ""),
    HOME_IMPROVEMENT_FIRST_TIME(SUBJECT.HOME_IMPROVEMENT, TYPE.FIRST_TIME, ""),
    HOME_IMPROVEMENT_PAST_TODAY(SUBJECT.HOME_IMPROVEMENT, TYPE.PAST_TODAY, ""),
    HOME_IMPROVEMENT_MEMORABLE(SUBJECT.HOME_IMPROVEMENT, TYPE.MEMORABLE, "Do you have an experience that you were in trouble while enjoying the home improvement project? What happened?"),
    HOME_IMPROVEMENT_PLACE(SUBJECT.HOME_IMPROVEMENT, TYPE.PLACE, ""),
    HOME_IMPROVEMENT_ACTIVITY(SUBJECT.HOME_IMPROVEMENT, TYPE.ACTIVITY, ""),
    HOME_IMPROVEMENT_PERSON(SUBJECT.HOME_IMPROVEMENT, TYPE.PERSON, ""),
    HOME_IMPROVEMENT_OBJECT(SUBJECT.HOME_IMPROVEMENT, TYPE.OBJECT, ""),
    HOME_IMPROVEMENT_W5H1(SUBJECT.HOME_IMPROVEMENT, TYPE.W5H1, "What kind of home improvement project do you usually do? How often, and with whom do you enjoy it?"),
    HOME_IMPROVEMENT_ACT_OUT(SUBJECT.HOME_IMPROVEMENT, TYPE.ACT_OUT, ""),
    HOME_IMPROVEMENT_ALTERNATIVE(SUBJECT.HOME_IMPROVEMENT, TYPE.ALTERNATIVE, ""),
    HOME_IMPROVEMENT_HAPPEN(SUBJECT.HOME_IMPROVEMENT, TYPE.HAPPEN, ""),
    HOME_IMPROVEMENT_ASK_ME(SUBJECT.HOME_IMPROVEMENT, TYPE.ASK_ME, ""),

    NEIGHBORHOOD_RECENT(SUBJECT.NEIGHBORHOOD, TYPE.RECENT, ""),
    NEIGHBORHOOD_BEFORE_AFTER(SUBJECT.NEIGHBORHOOD, TYPE.BEFORE_AFTER, ""),
    NEIGHBORHOOD_FIRST_TIME(SUBJECT.NEIGHBORHOOD, TYPE.FIRST_TIME, ""),
    NEIGHBORHOOD_PAST_TODAY(SUBJECT.NEIGHBORHOOD, TYPE.PAST_TODAY, "What is your neighborhood like? Are there many new buildings? Do many people move into your neighborhood? How has your neighborhood changed over the years?"),
    NEIGHBORHOOD_MEMORABLE(SUBJECT.NEIGHBORHOOD, TYPE.MEMORABLE, ""),
    NEIGHBORHOOD_PLACE(SUBJECT.NEIGHBORHOOD, TYPE.PLACE, "Can you describe the area around your home? Are there any parks or schools? Describe the neighborhood where you live in as much detail as possible."),
    NEIGHBORHOOD_ACTIVITY(SUBJECT.NEIGHBORHOOD, TYPE.ACTIVITY, ""),
    NEIGHBORHOOD_PERSON(SUBJECT.NEIGHBORHOOD, TYPE.PERSON, "Tell me about your neighbors. Are they nice people? Are you close to them?"),
    NEIGHBORHOOD_OBJECT(SUBJECT.NEIGHBORHOOD, TYPE.OBJECT, ""),
    NEIGHBORHOOD_W5H1(SUBJECT.NEIGHBORHOOD, TYPE.W5H1, ""),
    NEIGHBORHOOD_ACT_OUT(SUBJECT.NEIGHBORHOOD, TYPE.ACT_OUT, ""),
    NEIGHBORHOOD_ALTERNATIVE(SUBJECT.NEIGHBORHOOD, TYPE.ALTERNATIVE, ""),
    NEIGHBORHOOD_HAPPEN(SUBJECT.NEIGHBORHOOD, TYPE.HAPPEN, ""),
    NEIGHBORHOOD_ASK_ME(SUBJECT.NEIGHBORHOOD, TYPE.ASK_ME, "");



    SUBJECT mSubject;
    TYPE mType;
    String mQuestion;

    EXAM_QUESTION_BANK(SUBJECT subject, TYPE type, String question) {
        this.mSubject = subject;
        this.mType = type;
        this.mQuestion = question;
    };

    public SUBJECT getSubject() {
        return mSubject;
    }

    public void setSubject(SUBJECT subject) {
        this.mSubject = subject;
    }

    public TYPE getType() {
        return mType;
    }

    public void setType(TYPE type) {
        this.mType = type;
    }

    public String getQuestion() {
        return mQuestion;
    }

    public void setQuestion(String question) {
        this.mQuestion = question;
    }

    public enum SUBJECT {
        INTRO, //자기소개
        MOVIE, //영화
        PERFORMANCE, //공연
        CONCERT, //콘서트
        PARK, //공원
        BEACH, //해변
        SHOPPING, //쇼핑
        MUSIC, //음악
        SWIMMING, //수영
        BICYCLE, //자전거
        JOGGING, //조깅
        WALKING, //걷기
        HOME_VACATION, //집 휴가
        HOME, //집
        HOUSEHOLD, //집안일
        HOME_IMPROVEMENT, //집 개선
        NEIGHBORHOOD; //동네
    }

    public enum TYPE {
        INTRO, //자기소개
        RECENT, //최근경험
        BEFORE_AFTER, //시간순묘사
        FIRST_TIME, //계기변화
        PAST_TODAY, // 과거비교
        MEMORABLE, //특별경험
        PLACE, //장소묘사
        ACTIVITY, //활동묘사
        PERSON, //인물묘사
        OBJECT, //사물묘사
        W5H1, //육하원칙
        ACT_OUT, //상황극-질문하기
        ALTERNATIVE, //상황극-대안제시
        HAPPEN, //상황극-이런 경험
        ASK_ME; //상황극-나에게 질문
    }
}