// This file was generated by Mendix Studio Pro.
//
// WARNING: Only the following code will be retained when actions are regenerated:
// - the import list
// - the code between BEGIN USER CODE and END USER CODE
// - the code between BEGIN EXTRA CODE and END EXTRA CODE
// Other code you write will be lost the next time you deploy the project.
// Special characters, e.g., é, ö, à, etc. are supported in comments.

package coordinateconverter.actions;

import java.math.BigDecimal;
import org.locationtech.proj4j.CRSFactory;
import org.locationtech.proj4j.CoordinateReferenceSystem;
import org.locationtech.proj4j.CoordinateTransform;
import org.locationtech.proj4j.CoordinateTransformFactory;
import org.locationtech.proj4j.ProjCoordinate;
import com.mendix.systemwideinterfaces.core.IContext;
import com.mendix.webui.CustomJavaAction;
import com.mendix.systemwideinterfaces.core.IMendixObject;

public class JA_Coordinate_Convert extends CustomJavaAction<java.lang.Void>
{
	/** @deprecated use CoordinateConverter.getMendixObject() instead. */
	@java.lang.Deprecated(forRemoval = true)
	private final IMendixObject __CoordinateConverter;
	private final coordinateconverter.proxies.CoordinateConverter CoordinateConverter;
	private final java.lang.String SourceEpsgCode;
	private final java.lang.String TargetEpsgCode;

	public JA_Coordinate_Convert(
		IContext context,
		IMendixObject _coordinateConverter,
		java.lang.String _sourceEpsgCode,
		java.lang.String _targetEpsgCode
	)
	{
		super(context);
		this.__CoordinateConverter = _coordinateConverter;
		this.CoordinateConverter = _coordinateConverter == null ? null : coordinateconverter.proxies.CoordinateConverter.initialize(getContext(), _coordinateConverter);
		this.SourceEpsgCode = _sourceEpsgCode;
		this.TargetEpsgCode = _targetEpsgCode;
	}

	@java.lang.Override
	public java.lang.Void executeAction() throws Exception
	{
		// BEGIN USER CODE
		
        // Create a CoordinateReferenceSystem for each system
        CRSFactory crsFactory = new CRSFactory();
        CoordinateReferenceSystem sourceCrs = crsFactory.createFromName(SourceEpsgCode);
        CoordinateReferenceSystem targetCrs = crsFactory.createFromName(TargetEpsgCode);
        
        double initialX = CoordinateConverter.getXValueInitial().doubleValue();
        double initialY = CoordinateConverter.getYValueInitial().doubleValue();

        CoordinateTransformFactory transformFactory = new CoordinateTransformFactory();
        CoordinateTransform transform = transformFactory.createTransform(sourceCrs, targetCrs);

        // Perform the conversion
        ProjCoordinate initialCoordinate = new ProjCoordinate(initialX, initialY);
        ProjCoordinate convertedCoordinate = new ProjCoordinate();
        transform.transform(initialCoordinate, convertedCoordinate);

        BigDecimal convertedX = new BigDecimal(convertedCoordinate.x);
        BigDecimal convertedY = new BigDecimal(convertedCoordinate.y);

        CoordinateConverter.setXValueConverted(convertedX);
        CoordinateConverter.setYValueConverted(convertedY);
        
        return null;
		// END USER CODE
	}

	/**
	 * Returns a string representation of this action
	 * @return a string representation of this action
	 */
	@java.lang.Override
	public java.lang.String toString()
	{
		return "JA_Coordinate_Convert";
	}

	// BEGIN EXTRA CODE
	// END EXTRA CODE
}
