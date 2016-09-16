package subjects;

import observers.IObserver;


interface ISubject<T> {

	void registerObserver(IObserver o);
	void removeObserver(IObserver o);
	void notifyObservers(T t, String message);

}
