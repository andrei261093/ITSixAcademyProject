package itsix.academy.perfect_school.publisherSubscriber;

public interface IPublisher {
	
	public void subscribe(ISubscriber subscriber);

	public void unsubscribe(ISubscriber subscriber);
}
