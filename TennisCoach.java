package springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.stereotype.Component;

@Component ("tennisCoach")

public class TennisCoach implements Coach {
	
	@Autowired
	@Qualifier("randomFortuneService")
	private FortuneService fortuneService;
	
	// define a default constructor
	public TennisCoach() {
		System.out.println("TennisCoach: inside default constructor");
	}
	
	// define my init method
	@PostConstruct
	public void doMyStartStuff() {
		System.out.println("TennisCoach: inside of doMyStartStuff()");
	}
	
	
	// define my destroy method
	@PreDestroy
	public void doMyCleanStuff() {
		System.out.println("TennisCoach: inside of doMyCleanStuff()");
	}
	
	/* define a setter method
	@Autowired
	public void doSomeCrazyShit(FortuneService theFortuneService) {
		System.out.println("TennisCoach: inside doSomeCrazyShit() method");
		fortuneService = theFortuneService; 
	} */
	
	/*
	@Autowired
		TennisCoach(FortuneService theFortuneService) {
			fortuneService = theFortuneService;
		}
	*/	
	
	@Override
	public String getDailyWorkout() {
		return "Practice your backhand";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}
	
	
}
