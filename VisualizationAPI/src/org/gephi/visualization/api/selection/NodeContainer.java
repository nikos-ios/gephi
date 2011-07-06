/*
Copyright 2008-2011 Gephi
Authors : Vojtech Bardiovsky <vojtech.bardiovsky@gmail.com>
Website : http://www.gephi.org

This file is part of Gephi.

Gephi is free software: you can redistribute it and/or modify
it under the terms of the GNU Affero General Public License as
published by the Free Software Foundation, either version 3 of the
License, or (at your option) any later version.

Gephi is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU Affero General Public License for more details.

You should have received a copy of the GNU Affero General Public License
along with Gephi.  If not, see <http://www.gnu.org/licenses/>.
*/

package org.gephi.visualization.api.selection;

import java.awt.Point;
import java.util.Collection;
import org.gephi.graph.api.Node;

/**
 * Interface for data structures containing nodes and allowing effective 
 * selection algorithms.
 *
 * @author Vojtech Bardiovsky
 */
public interface NodeContainer {

    /**
     * Select first node found among all nodes within radius.
     */
    public static final int SINGLE_NODE_FIRST = 0;

    /**
     * Select the largest node among all nodes within radius.
     */
    public static final int SINGLE_NODE_LARGEST = 1;
    
    /**
     * Select the closes node among all nodes within radius.
     */
    public static final int SINGLE_NODE_CLOSEST = 2;

    public void rebuild();

    /**
     * Add or remove nodes from given shape to selection.
     * @return nodes added to selection that were not selected before.
     */
    public Collection<Node> applySelection(Shape shape);

    /**
     * Adds nodes from inside the shape to a temporary selection.
     * @see #cancelContinuousSelection()
     */
    public void applyContinuousSelection(Shape shape);

    /**
     * Cancels temporary selection.
     */
    public void cancelContinuousSelection();
    
    public Collection<Node> getSelectedNodes();

    /**
     * Adds or removes single node from a permanent selection.
     * @param point the point to determine the closest node.
     * @param select true to select, false to deselect.
     */
    public Node selectSingle(Point point, final boolean select, final int selectionRadius, final int policy);

    /**
     * Adds or removes single node from a temporary selection.
     * @param point the point to determine the closest node.
     * @param select true to select, false to deselect.
     * @return true if node has been selected.
     */
    public boolean selectContinuousSingle(Point point, final boolean select, final int selectionRadius, final int policy);

    /**
     * Clears single node from a temporary selection.
     * @param point the point to determine the closest node.
     * @param select true to select, false to deselect.
     */
    public void deselectSingle();

    public void clearSelection();

    public void addNode(Node node);

    public void removeNode(Node node);

    /**
     * Returns the size of a node with maximum size.
     */
    public float getMaxNodeSize();

}