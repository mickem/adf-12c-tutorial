package name.medin.tutorial.adf.intro.model.common;

import org.eclipse.persistence.sdo.SDODataObject;

@SuppressWarnings("serial")
public class AllJobsViewSDOImpl extends SDODataObject implements AllJobsViewSDO {

   public static final int START_PROPERTY_INDEX = 0;

   public static final int END_PROPERTY_INDEX = START_PROPERTY_INDEX + 1;

   public AllJobsViewSDOImpl() {}

   public java.lang.String getJobId() {
      return getString(START_PROPERTY_INDEX + 0);
   }

   public void setJobId(java.lang.String value) {
      set(START_PROPERTY_INDEX + 0 , value);
   }

   public java.lang.String getJobTitle() {
      return getString(START_PROPERTY_INDEX + 1);
   }

   public void setJobTitle(java.lang.String value) {
      set(START_PROPERTY_INDEX + 1 , value);
   }


}

