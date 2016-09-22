package itsix.academy.perfect_school.publisherSubscriber.implementations;

import java.util.List;

import itsix.academy.perfect_school.publisherSubscriber.IInnerPublisher;
import itsix.academy.perfect_school.publisherSubscriber.ISubscriber;

public class Publisher implements IInnerPublisher {

	private List<ISubscriber> subscribers;

	public Publisher(List<ISubscriber> subscribers) {
		this.subscribers = subscribers;
	}

	@Override
	public void subscribe(ISubscriber subscriber) {
		if (!subscribers.contains(subscriber)) {
			subscribers.add(subscriber);
		}
	}

	@Override
	public void unsubscribe(ISubscriber subscriber) {
		subscribers.remove(subscriber);

	}

	@Override
	public void notifySubscribers() {
		for (ISubscriber subscriber : subscribers) {
			subscriber.updatePackagesList();
		}
	}

}