package by.rudenko.testproject.model;

/**
 * Task type.
 */
public enum TaskType {
	
	DELETE{
		public String getDescription() {
			return "delete single robot";
		}
	}, DO{
		public String getDescription() {
			return "task for single robot";
		}
	}, DOALL {
		public String getDescription() {
			return "task for all robot";
		}
	};
	
	abstract String getDescription();
	
}
