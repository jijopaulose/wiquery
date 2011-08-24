package org.odlabs.wiquery.core.resources;

import org.apache.wicket.Application;
import org.apache.wicket.request.resource.CssPackageResource;
import org.apache.wicket.request.resource.IResource;
import org.apache.wicket.request.resource.ResourceReference;
import org.apache.wicket.resource.dependencies.AbstractResourceDependentResourceReference;
import org.apache.wicket.util.lang.Packages;
import org.apache.wicket.util.resource.IResourceStream;
import org.apache.wicket.util.resource.locator.IResourceStreamLocator;
import org.odlabs.wiquery.core.WiQuerySettings;

/**
 * <p>
 * {@link ResourceReference} which checks the {@link WiQuerySettings} if the resources
 * needs to fetch the normal (non-minimized) version or the minimized version.
 * </p>
 * 
 * <p>
 * Note that this ResourceReference only loads files and does not minify on the fly.
 * </p>
 * 
 * <p>
 * Always provide the normal (non-minimized) version, wiquery will reference to the
 * minimized version when {@link WiQuerySettings#isMinifiedStyleSheetResources()} is true.
 * </p>
 * <p>
 * The filename format for the 2 versions is:
 * <ul>
 * <li>Normal version: <i>foo.js</i> / <i>foo.css</i></li>
 * <li>Minimized version: <i>foo.min.js</i> / <i>foo.min.css</i></li>
 * </ul>
 * </p>
 * 
 * @author Hielke Hoeve
 */
public class WiQueryStyleSheetResourceReference extends AbstractResourceDependentResourceReference
{
	private static final long serialVersionUID = 1L;

	private Boolean minified = null;

	public WiQueryStyleSheetResourceReference(Class< ? > scope, String name)
	{
		super(scope, name, null, null, null);
	}

	private boolean exists(Class< ? > scope, String name)
	{
		IResourceStreamLocator locator =
			Application.get().getResourceSettings().getResourceStreamLocator();
		String absolutePath = Packages.absolutePath(scope, name);
		IResourceStream stream =
			locator
				.locate(scope, absolutePath, getStyle(), getVariation(), getLocale(), null, true);
		return stream != null;
	}

	@Override
	public String getName()
	{
		String name = super.getName();
		String minifiedName = name.substring(0, name.length() - 3) + "min.css";
		if (minified == null)
			minified = isMinifiedStyleSheetResources() && exists(getScope(), minifiedName);
		if (minified)
			return minifiedName;
		return name;
	}

	public static boolean isMinifiedStyleSheetResources()
	{
		return WiQuerySettings.get().isMinifiedStyleSheetResources();
	}

	/**
	 * @return default an empty list as all subclasses must implement this to fit their
	 *         own needs.
	 */
	@Override
	public AbstractResourceDependentResourceReference[] getDependentResourceReferences()
	{
		return new AbstractResourceDependentResourceReference[0];
	}

	@Override
	public IResource getResource()
	{
		return new CssPackageResource(getScope(), getName(), getLocale(), getStyle(),
			getVariation());
	}

}
